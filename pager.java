/* package whatever; // don't place package name! */

import java.lang.*;

import java.util.*;
import java.io.*;

class PageRank {
  
    public double path[][] = new double[10][10];
    public double pagerank[] = new double[10];
  
public void calc(double n)
{    
 double init;
 double c=0; 
 double temp[] = new double[10];
 int i,j,u=1,k=1;
 init = 1/n;

 for(i=0;i<n;i++)
   this.pagerank[i]=init;
   System.out.printf("\n Initial PageRank Values , 0th Step \n");
    for(i=0;i<n;i++)
   System.out.printf(" Page Rank of "+i+" is :\t"+this.pagerank[i]+"\n");
   
   
   while(u<=9)
   {
	   for(int ii=0;ii<n;ii++)
	   {
		   temp[ii]=0;
		   for(int jj=0;jj<n;jj++)
		   {
				   temp[ii]=temp[ii]+this.path[ii][jj]*this.pagerank[jj];

		   }
		   
	   
	   }
	   for(int ik=0;ik<n;ik++)
		   this.pagerank[ik]=temp[ik];
	   

  System.out.printf("\n In "+u+"th Iteration \n"); 
     for(i=0;i<n;i++) 
      System.out.printf("Rank Value of "+i+" is :\t"+this.pagerank[i]+"\n"); 
   
     u=u+1;
    } 
}
 public static void main(String args[])throws java.lang.Exception
    {
        int nodes,i,j,cost;
		
      
		Main pg=new Main();
		//System.out.println("Total pages are:");
		nodes=pg.total("jweb.html");
		System.out.println("Total no of pages:"+nodes);

		Getpp gt=new Getpp();
        PageRank p = new PageRank();
		for(int f=0;f<nodes;f++)
			for(int x=0;x<nodes;x++)
				p.path[f][x]=0;

		for(int w=0; w<nodes; w++)
		{
			ArrayList<String> list = new ArrayList<String>();
			list=gt.getp("ab"+Integer.toString(w)+".html");
			
			double lsz=list.size();
			
			System.out.println("Links in page:"+w+":"+list);
			System.out.println("No.of pages:"+lsz);
			for(int d=0;d<list.size();d++)
			{
				//System.out.println("list check for:"+list.get(d));
				for(int q=0;q<nodes;q++)
				{
					
					
					if(list.get(d).equals("ab"+Integer.toString(q)+".html"))
					p.path[q][w]=1/lsz;
				     
					
					
				
				}
				System.out.println();
			}
		}
		System.out.println("The input matrix relation between pages:");
		for(int f=0;f<nodes;f++)
		{for(int h=0;h<nodes;h++)
				System.out.print(p.path[f][h]+"  ");
		System.out.println();}
        
        p.calc(nodes);
    
           
    }   
 
}



