public class indirectsort{

public static void mergesort(int[]a,int[]aux,int[]perm,int lo,int hi,int mid)
{
    
    for(int z=lo;z<=hi;z++)
     {
    aux[z]=perm[z];

     }

int i=lo;
int j=mid+1;


for(int k=lo;k<=hi;k++)
{

if(i>mid)
{
perm[k]=aux[j++];

}

else if(j>hi)
{
    perm[k]=aux[i++];
    
}

else if(a[aux[i]]<a[aux[j]])
{
  perm[k]=aux[i++];
  
}

else if(a[aux[i]]>a[aux[j]])
{
     perm[k]=aux[j++];
     
}

}
}

public static void indirect(int[]a,int []aux,int[]perm,int lo,int hi)
{
    if(hi<=lo)
    return;

   int mid=lo+(hi-lo)/2;
  
   indirect(a,aux,perm,lo,mid);
   indirect(a,aux,perm,mid+1,hi);
   mergesort(a,aux,perm,lo,hi,mid);
		


}

public static int[] sort(int []a)
{
    int []perm=new int[a.length];
    int []aux= new int[a.length];

    for(int i=0;i<a.length;i++)
    {
        perm[i]=i;
    }

    indirect(a,aux,perm,0,a.length-1);

    



    return perm;

}



public static void main(String[] args) 
{
int a[]={3,1,2,6,8,9,0};
System.out.println("Result: ");

for(int v=0;v<a.length;v++)
    {
        System.out.print(sort(a)[v]+ " ");
    }

} 







}