#include <ioavr.h>

#include <intrinsics.h>
void initDevices()
{
  DDRD= 0xFF;
  DDRB= 0x00;
  DDRE= 0xff;
  DDRF = 0xFF;
  
  //PORTA=0x00;
  //EICRA |= (1<<ISC21)| (1<<ISC11) | (1<<ISC01);
  TCCR0 |= (1<<CS01);
  TIMSK |= (1<<TOIE0) | (1<<TOIE1) | (1<<TOIE2);
  TCCR1B= (1<<CS12) | (0<< CS11)| (0<<CS10);
  TCCR2 |= (1<<CS21);
}
__flash unsigned char numbers[] = {0x7B, 0x41, 0x37, 0x67, 0x4D, 0x6E, 0x7E, 0x43, 0x7F, 0x6F};
volatile unsigned char LED[] = {0x7F, 0xBF, 0xDF, 0xEF, 0xF7, 0xFB};
__flash unsigned char numbersDOT[] = {0xFB, 0xC1, 0xB7, 0xE7, 0xCD, 0xEE, 0xFE, 0xc3, 0xFF, 0xEF};
volatile unsigned char change[] = {2,3,5,9,5,9};
volatile unsigned char setTime[] = {0,0,0,0,0,0};
volatile unsigned char setAlarm[] = {0,0,0,0,0,0};
volatile unsigned char alarmStateON[] = {0x7B, 0x5B, 0x80, 0x80, 0x80, 0x80};
volatile unsigned char alarmStateOFF[] = {0x7B,0x1E,0x1E,0x80,0x80,0x80};
volatile unsigned char table[] = {0,0,0,0,0,0};
volatile unsigned char a=0x00;
volatile unsigned char b=0x00;
volatile unsigned char i=0;
volatile unsigned char applyTime=0;
volatile unsigned char position = 0;
volatile unsigned char alarmCalled = 0;
volatile unsigned char alarmState = 0;
volatile unsigned char alarmView = 0;
volatile unsigned char cancelAction = 0;
volatile unsigned char notDisplayAlarm = 0;

volatile unsigned char rememberSetAlarm[] = {0,0,0,0,0,0};
volatile unsigned char rememberAlarmState = 0;


volatile unsigned char b1 = 0;
volatile unsigned char b2 = 0;
volatile unsigned char b3 = 0;
volatile unsigned char b4 = 0;
volatile unsigned char bc = 0;
volatile unsigned char b1c = 0;
volatile unsigned char b2c = 0;
volatile unsigned char b3c = 0;
volatile unsigned char b4c = 0;



#pragma vector=TIMER1_OVF_vect
__interrupt void sniew() //zwyk³y zegar 24h
{
      TCNT1=36735;
 if (change[5]++==9)
 {
   change[5]=0;
   if (change[4]++==5)
    {
      change[4]=0;
      if (change[3]++==9)
    {
      change[3]=0;
      if (change[2]++==5)
    {
      change[2]=0;
       if(change[0]==2 &&change[1]==3)
       {
         change[0]=0;
         change[1]=0;
       }
       else{
              if (change[1]++==9)
            {
              change[1]=0;
              //change[0]++;
              if (change[0]++==2)
            {
              change[0]=0;
            }
            }
        }
    }
    }
    }
 }
 if(alarmState==1){
     if(setAlarm[0]==change[0] && setAlarm[1]==change[1] && setAlarm[2]==change[2] && setAlarm[3]==change[3] && setAlarm[4]==change[4] && setAlarm[5]==change[5]){
     
        alarmCalled = 1;
     }
 }
 if(alarmView>0){
    if(alarmView++==3) alarmView=0;
 }
 

}
#pragma vector=TIMER0_OVF_vect
__interrupt void led()
{
 if (i++==5) i=0; // iteracja po pozycjach wyœwietlacza
}

#pragma vector=TIMER2_OVF_vect
__interrupt void buttons(){
  TCNT2=7035;
   if(~PINB&0x01){
    b1=1;

    
    } 
   if(~PINB&0x02){
    b2=1;     
    }
      if(~PINB&0x04){
    b3=1;     
    }
         if(~PINB&0x08){
    b4=1; 
    if(alarmCalled==1){
        alarmCalled = 0; 
        b4=0;
    }  
    }

  if(!(~PINB&0x01)){
     b1c=0;
    b1=0;
  }
    if(!(~PINB&0x02)){
     b2c=0;
    b2=0;
  }
      if(!(~PINB&0x04)){
     b3c=0;
    b3=0;
  }
        if(!(~PINB&0x08)){
     b4c=0;
    b4=0;
  }
  
}


void arrayWrite(volatile unsigned char* array1,  volatile unsigned char* array2){
          array1[0] = array2[0];
          array1[1] = array2[1];
          array1[2] = array2[2];
          array1[3] = array2[3];
          array1[4] = array2[4];
          array1[5] = array2[5];
}
//-----------------------
unsigned char setting(int type, unsigned char position,  unsigned char cancelAction, volatile unsigned char* array){
  int applyTime = 0;
  
               while(applyTime==0 && cancelAction==0){
                 if(position==0){
                     if(i==0 || i==1){
                        PORTD=numbersDOT[array[i]];                   
                    }
                    else{
                     PORTD=numbers[array[i]];
                   }
                 }
                    if(position==1){
                     if(i==2 || i==3){
                        PORTD=numbersDOT[array[i]];                   
                    }
                    else{
                     PORTD=numbers[array[i]];
                   }
                 }
                 if(position==2){
                     if(i==4 || i==5){
                        PORTD=numbersDOT[array[i]];                   
                    }
                    else{
                     PORTD=numbers[array[i]];
                   }
                 }

               PORTE=LED[i];
               if(b2==1 && (b2c==0)){
                 b2c=1;
                 if(position==0){
                     if(array[0]==2 && array[1]==3)
                       {
                         array[0]=0;
                         array[1]=0;
                       }
                       else{
                              if (array[1]++==9)
                            {
                              array[1]=0;
                              if (array[0]++==2)
                            {
                              array[0]=0;
                            }
                            }
                        } 
                 }
                 if(position==1){
                      if (array[3]++==9)
                      {
                        array[3]=0;
                        if (array[2]++==5)
                      {
                        array[2]=0;
                      }
                      }
                 }
                 if(position==2){
                       if (array[5]++==9)
                      {
                        array[5]=0;
                        if (array[4]++==5)
                      {
                        array[4]=0;
                      }
                      } 
                 }
               }
                        
                  if(b3==1 && (b3c==0)){
                     if(type==0){
                     applyTime=1;
                     }
                     b3c=1;
                   }
                   if(b1==1 && (b1c==0)){
                     if(type==1){
                     applyTime=1;
                     }
                     b1c=1;
                   }
             if(b4==1 && (b4c==0)){          
             cancelAction=1;
             b4c=1;
          }

             }
             return cancelAction;
}
//-----------------------


void main( void )
{
  initDevices();
  __enable_interrupt();
  
  for(;;)
  {
    if(alarmView>0){
       PORTD=numbers[setAlarm[i]];       
    }
    else{
      PORTD=numbers[change[i]];
    }
        PORTE=LED[i];
        if(alarmCalled==0){
            PORTF=~0x00;
        }
        else{
            PORTF=~0x04;
        }
          if(b4==1 && (b4c==0)){ 
            if(notDisplayAlarm==0){
             alarmView=1;
            }
            else{
            notDisplayAlarm=0;
            }
             b4c=1;
          }
 
           if((b1==1) && (b1c==0)){
            b1c=1;
            PORTF=~0x01;
            arrayWrite(setTime, change);
          
          PORTD=0x00;
          //PORTE=0x00;
          
          if(position==0){//-------------------------------          
          cancelAction= setting(0, position,cancelAction, setTime);        
             position=1;
          }
            if(position==1 && cancelAction==0){//------------------------------
             cancelAction= setting(0, position,cancelAction, setTime);
             position = 2;
          }
            if(position==2 && cancelAction==0){//-----------------------          
             cancelAction= setting(0, position,cancelAction, setTime);
             position = 0;
          }
          //idz na pozycje z minutami, ustawiaj tak samo minuty potem sekundy i potem apply ma zatwierdzac  przepisywac godzine do chage[]
          if(cancelAction==0){
            arrayWrite(change, setTime);
          }
          else{
          notDisplayAlarm=1;
          cancelAction=0;
          }
          
          position=0;
          
          
             
  }
      //ustawianie godziny koniec-------------------------------------------------------------------------------------------------------------------------------------------


           if((b3==1) && (b3c==0)){
            b3c=1;
           PORTF=~0x02;

          PORTD=0x00;
          //PORTE=0x00;
          rememberAlarmState=alarmState;
          arrayWrite(rememberSetAlarm, setAlarm);
          //-----------------------------------------------------------------
        
             while(applyTime==0 && cancelAction ==0){
               if(alarmState==0){
                    PORTD=alarmStateOFF[i];
                    
               }
               else{
                 PORTD=alarmStateON[i];
               }
               PORTE=LED[i];
               if(b2==1 && (b2c==0)){
                  b2c=1;
                  if(alarmState==0){
                    alarmState=1;
                  }
                  else{
                    alarmState=0;
                  }
               }
            
            
               if(b1==1 && (b1c==0)){
                 applyTime=1;
                 b1c=1;
               }
            if(b4==1 && (b4c==0)){          
             cancelAction=1;
             b4c=1;
          }

             }
             applyTime=0;
          
          //-----------------------------------------------------------------
          
          if(position==0 && cancelAction==0){                  
           cancelAction= setting(1, position,cancelAction, setAlarm);
             position=1;
          }
            if(position==1 && cancelAction==0){

             cancelAction= setting(1, position,cancelAction, setAlarm);
             position = 2;
          }
           if(position==2 && cancelAction==0){
            

            cancelAction=setting(1, position,cancelAction, setAlarm);
             position = 0;
          }
   
          if(cancelAction==1){
            arrayWrite(setAlarm, rememberSetAlarm);
          alarmState=rememberAlarmState;
          notDisplayAlarm=1;
          }
                   
  }
           
  }
}
