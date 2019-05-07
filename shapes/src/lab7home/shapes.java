package lab7home;

import java.util.*;
import java.awt.*;

abstract public class shapes 
{
   protected int x1;
   protected int y1;
   protected Color c;
   
   public shapes(int x1,int y1,Color c)
   {
       this.x1=x1;
       this.y1=y1;
       this.c=c;       
   }
   
   public abstract void draw(Graphics g);
}

class line extends shapes
{
    private int x2;
    private int y2;
    
    public line(int x1,int y1,Color c,int x2,int y2)
    {
        super(x1,y1,c);
        this.x2=x2;
        this.y2=y2;
    }
    
    @Override
    public void draw(Graphics g)
    {
        g.setColor(this.c);
        g.drawLine(x1, y1, x2, y2);
    }
}

class Oval extends shapes
{
    private int h,w;
    private boolean isfilled;
    
    public Oval(int h,int w,boolean isfilled,int x1,int y1,Color c)
    {
        super(x1,y1,c);
        this.h=h;
        this.w=w;
        this.isfilled=isfilled;
    }
    
    @Override
    public void draw(Graphics g)
    {
        g.setColor(c);
        if(isfilled){
        g.fillOval(x1, y1,w,h);
        }
        else{
            g.drawOval(x1, y1,w,h);
        }
            
    }
        
}
class rectangle extends shapes
{
    private int x2,y2;
    private boolean isfilled;
    public rectangle(int x1,int y1,Color c,int x2,int y2,boolean isfilled)
    {
        super(x1,y1,c);
        this.x2=x2;
        this.y2=y2;
        this.isfilled=isfilled;
    }
    
    @Override
    public void draw(Graphics g)
    {
        g.setColor(c);
        if(isfilled)
        {
            g.fillRect(x1, y1, x2, y2);
        }
        else
        {
            g.drawRect(x1, y1, x2, y2);
        }
    }
}