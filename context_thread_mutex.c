#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/syscall.h>
#include<pthread.h>

#define TURN 1000000

pthread_mutex_t A;
pthread_mutex_t B;
pthread_mutex_t START;
//int i;
unsigned long long min = 10000000000;

static __inline__ unsigned long long rdtsc(void)
{
  unsigned hi, lo;
  __asm__ __volatile__ ("rdtsc" : "=a"(lo), "=d"(hi));
  return ( (unsigned long long)lo)|( ((unsigned long long)hi)<<32 );
}

void* thread_A(void *arg)
{
  pthread_mutex_lock(&START);
  pthread_mutex_unlock(&START);
  //printf("A start\n");
  int i = 0;
  //while(i*2<TURN) {
  while(1) {
    
    pthread_mutex_unlock(&A);
    //printf("%d\n",i);
    i++;
    printf("A in\n");
    pthread_mutex_lock(&B);
    
  }
  pthread_exit(0);
}

void* thread_B(void *arg)
{
  pthread_mutex_lock(&START);
  pthread_mutex_unlock(&START);
  //printf("B start\n");
  while(1) {
    unsigned long long t3 = rdtsc();
    pthread_mutex_lock(&A);
    //i++;
    //printf("B in,%d\n",i);
    printf("B in\n");
    pthread_mutex_unlock(&B);
    unsigned long long t4 = rdtsc();
    if (t4-t3<min) {
      min = t4-t3;
    }
    //printf("%lf\n",(double)(t4-t3)/3.192456);
  }
  pthread_exit(0);
}

int
main(int argc, char *argv[])
{
  pthread_t ida;
  pthread_t idb;
  pthread_mutex_init(&A,NULL);
  pthread_mutex_init(&B,NULL);
  pthread_mutex_init(&START,NULL);
  pthread_mutex_lock(&START);
  pthread_create(&ida, NULL, thread_A, NULL);
  pthread_create(&idb, NULL, thread_B, NULL);



  unsigned long long t1 = rdtsc();
  pthread_mutex_lock(&A);
  pthread_mutex_lock(&B);
  pthread_mutex_unlock(&START);
  //pthread_join(ida,NULL);
  sleep(7);
  unsigned long long t2 = rdtsc();
  //pthread_join(idb,NULL);

  //unsigned long long t2 = rdtsc();

  double time = (double)(min)/3.192456;
  printf("%lf\n",time);

  return 0;

}

