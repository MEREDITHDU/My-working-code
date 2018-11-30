?// Kacper Krajcar, Krzysztof Matysik
#include <stdio.h>
#include <stdlib.h>
#include <math.h> 
// jako sprawozdanie kod programu, rozszerzenie C, na maila : daniel.kostrzewa@polsl.pl , //zadanie 2, kazdy z procesow ma tyle samo do //wykonania
// n i k, n jest podzielne przez k bez reszty. kazdy z procesow potomnych ma n*k procesow do 
//policzenia
// kazdy z procesow potomnych ma licznik
// tylko jeden potok
// dla 12 elementow jest 147costamcostam

int n = 12;
int k = 3; // zmienic na przekazywanie 
float licz_element(int i,int n)
{	

	return pow((i*i-12),3)/(pow(n,3)*pow(i,3));
}
int main(int argc, char * argv[])
{

	float wyniki_potomne[k];
	float wyniki_potomne_tmp;
	float suma=0;
	int odbierzPotok[2];
	int NdoK=n/k;
	int i=0;
	int j=1;
	int l=0;
	int m=0;
	float potomne_suma_czesciowa[k];
	for (i=0;i<k;i++)
	{
		if(fork()==0)
		{
			while(1)
			{	
				for(l=1;l<=NdoK;l++)
				{
					j=l+(i*NdoK);
					wyniki_potomne_tmp=licz_element(j,n);
					potomne_suma_czesciowa[i]=potomne_suma_czesciowa[i]+wyniki_potomne_tmp;
				}
				write(odbierzPotok[1],&potomne_suma_czesciowa[i],sizeof(float));
				exit(0);
			}
		}
	
	}
	
	
	for(i=0;i<k;i++)
	{
		read(odbierzPotok[0],&potomne_suma_czesciowa[i],sizeof(float));
		suma=suma+potomne_suma_czesciowa[i];
	}
	
	printf("Wynik = %f",suma);
	return 0;
}