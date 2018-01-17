x = simplecluster_dataset; x1=x(1,:)'; x2=(x(2,:))';
% load('2_clusters.dat'); x1=X2_clusters(:,1); x2=X2_clusters(:,2);
 %load('4_clusters.dat'); x1=X4_clusters(:,1); x2=X4_clusters(:,2);
% load('ALFA.DAT'); x1=ALFA(:,1); x2=ALFA(:,2);
% load('banana_points.dat'); x1=banana_points(:,1); x2=banana_points(:,2);
% load('rings_points.dat'); x1=rings_points(:,1); x2=rings_points(:,2);
% load('spirala_points.dat'); x1=spirala_points(:,1); x2=spirala_points(:,2);
 %load('zigzag_points.dat'); x1=zigzag_points(:,1); x2=zigzag_points(:,2);
% load('COS.dat'); x1=COS(:,1); x2=COS(:,2); 

N=length(x1);  %input data size

% random input data !!!
% % % N=1000;
% % % for i=1:N
% % %     x1(i)=rand;
% % %     x2(i)=rand;
% % % end

% weights dimensions N1xN2
% neurons weights initialization
N1=4; % initial value N1=10
N2=4; % initial value N2=10
% NN = N1 * N2 <--- nr of neurons
for j1=1:N1
    for j2=1:N2
%%%%%%% 1st initialization        
        w1(j1,j2)=rand*(0.52-0.48)+0.48;
        w2(j1,j2)=rand*(0.52-0.48)+0.48;

%%%%%%% 2nd initialization
%         w1(j1,j2)=rand;
%         w2(j1,j2)=rand;

%%%%%%% 3rd initialization
%           w1(j1,j2)=j1/N1;
%           w2(j1,j2)=j2/N2;
    end
end

figure(1)
plot(x1,x2,'.b'); % input data
hold on
plot(w1,w2,'or'); % points
plot(w1,w2,'k','linewidth',2); % net in I dimension
plot(w1',w2','k','linewidth',2); % net in 2nd dimension
hold off
title('t=1');
drawnow

no=0.1;    % learing rate (alpha)(initial value no=1)
do=1.5;    % neighbourhood (initial value do=5)
T=1000;   % nr of learning cycles
t=1;

%
% MAIN LOOP of KOHONEN PROCEDURE of LEARNING
%
while (t<=T)
    n=no*(1-t/T);                  % modification of learning rate
    d=round(do*(1-t/T));           % modification of neighbourhood size
    % loop for the 1000 inputs
%     for i=1:N
    i = randi(N);                  % selection of ONE INPUT PATTERN
    e_norm=(x1(i)-w1).^2+(x2(i)-w2).^2;      % calculation of distance
%         e_norm=abs(x1(i)-w1)+abs(x2(i)-w2);
    minj1=1;
    minj2=1;
    min_norm=e_norm(minj1,minj2);
    % looking for winning neuron to updating its weights !!!!
    for j1=1:N1
        for j2=1:N2
            if e_norm(j1,j2)<min_norm
                min_norm=e_norm(j1,j2);
                minj1=j1;
                minj2=j2;
            end
        end
    end
    % coordinates of winning neuron (j1star, j2star) !!!!
    j1star= minj1;
    j2star= minj2;

    % update weights of the winning neuron
    w1(j1star,j2star)=w1(j1star,j2star)+n*(x1(i)-w1(j1star,j2star));
    w2(j1star,j2star)=w2(j1star,j2star)+n*(x2(i)-w2(j1star,j2star));

    %update the neighbour neurons in 4 directions !!!!
    for dd=1:1:d
        jj1=j1star-dd; % 1st direction
        jj2=j2star;
        if(jj1>=1)
          w1(jj1,jj2)=w1(jj1,jj2)+n*(x1(i)-w1(jj1,jj2));
          w2(jj1,jj2)=w2(jj1,jj2)+n*(x2(i)-w2(jj1,jj2));
        end
        jj1=j1star+dd; % 2nd direction
        jj2=j2star;
        if(jj1<=1)
          w1(jj1,jj2)=w1(jj1,jj2)+n*(x1(i)-w1(jj1,jj2));
          w2(jj1,jj2)=w2(jj1,jj2)+n*(x2(i)-w2(jj1,jj2));
        end
        jj1=j1star; % 3rd direction
        jj2=j2star-dd;
        if(jj2>=N1)
          w1(jj1,jj2)=w1(jj1,jj2)+n*(x1(i)-w1(jj1,jj2));
          w2(jj1,jj2)=w2(jj1,jj2)+n*(x2(i)-w2(jj1,jj2));
        end
        jj1=j1star; % 4th direction
        jj2=j2star+dd;
        if(jj2<=N2)
          w1(jj1,jj2)=w1(jj1,jj2)+n*(x1(i)-w1(jj1,jj2));
          w2(jj1,jj2)=w2(jj1,jj2)+n*(x2(i)-w2(jj1,jj2));
        end
        
    end  % for update the neighbourhood neurons
%     end; % end for i loop
    t=t+1;
    figure(2)
    plot(x1,x2,'.b')
    hold on
    plot(w1,w2,'or','MarkerSize',10,'MarkerFaceColor','r')
plot(w1,w2,'k','linewidth',2); % net in I dimension
plot(w1',w2','k','linewidth',2); % net in 2nd dimension
    hold off
    title(['t=' num2str(t),' Neighbourhood= ',num2str(d),' LearningRate= ',num2str(n)]);
    drawnow
    
end
% figure(3)
% plot(w1,w2,'ro'); title('learnt neurons weights');
% 

%%% coloring the clusters %%%
