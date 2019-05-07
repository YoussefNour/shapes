package lab7home;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import lab7home.shapes.*;
import lab7home.*;

public class randpainter extends JFrame
{
    
    private PaintPanel paintpanel;
    private JPanel buttompanel;
    private JButton randpaintbtn;       
            
    public randpainter()
    {
        inti();
    }
    private void inti()
    {
        this.setTitle("Random Paint");
        this.setBounds(100,100,600,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container con = getContentPane();
        
        paintpanel = new PaintPanel();
        paintpanel.setBackground(Color.white);
        con.add(paintpanel,BorderLayout.CENTER);
        
        buttompanel = new JPanel();
        buttompanel.setBackground(Color.gray);
        con.add(buttompanel,BorderLayout.SOUTH);
        
        randpaintbtn = new JButton("surprise me");
        buttompanel.add(randpaintbtn);
        
        randpaintbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randpaintbtn_pressed(e);
            }
        });
        
        paintpanel.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                randpaintbtn_mousepressed(e);
            }
        });           
    }
    
    class PaintPanel extends JPanel 
    {
        private ArrayList<shapes> shps;
        
        public PaintPanel()
        {
            this.shps = new ArrayList<shapes>();
        }
        
        public void addshape(shapes s)
        {
            this.shps.add(s);
        }
        
        @Override
        public void paint(Graphics g)
        {
            super.paint(g);
            for(int i = 0;i<shps.size();i++)
            {
                (shps.get(i)).draw(g);
            }
        }
        
    }
    
    public void randpaintbtn_mousepressed(MouseEvent e)
    {
        Random randgen = new Random();
        
        int shptype = randgen.nextInt(3);
        int r = randgen.nextInt(256);
        int g = randgen.nextInt(256);
        int b = randgen.nextInt(256);
        Color c_rand = new Color(r,g,b);
        
        int x1 = e.getX();
        int y1 = e.getY();
        
        shapes shp = null ;
        
        switch(shptype)
        {
            case 0:
            {
                int w = randgen.nextInt(201);
                int h = randgen.nextInt(201);
                int x2 = x1+w;
                int y2 = y1+h;
                shp = new line(x1, y1, c_rand, x2, y2);
            }
            break;
            case 1:
            {
                int w = randgen.nextInt(201);
                int h = randgen.nextInt(201);
                boolean isfilled = randgen.nextBoolean();
                shp = new rectangle(x1, y1, c_rand, x1, y1, isfilled);
            }
            break;
            case 2:
            {
                int w = randgen.nextInt(201);
                int h = randgen.nextInt(201);
                boolean isfilled = randgen.nextBoolean();
                shp = new Oval(h, w, isfilled, x1, y1, c_rand);
            }
            break;
        }
        paintpanel.addshape(shp);
        paintpanel.repaint();
    }
    public void randpaintbtn_pressed(ActionEvent e) {
        Random randGen = new Random();

        int shpType = randGen.nextInt(3); //0[line],1[Rect],2[Oval]
        //random color
        int r = randGen.nextInt(256);
        int g = randGen.nextInt(256);
        int b = randGen.nextInt(256);
        Color c_rand = new Color(r, g, b);

        int x1 = randGen.nextInt(paintpanel.getWidth() - 200);
        int y1 = randGen.nextInt(paintpanel.getHeight() - 200);


        shapes shp = null;
        switch (shpType) {
            case 0://line
            {
                int w = randGen.nextInt(201);
                int h = randGen.nextInt(201);
                int x2 = x1 + w;
                int y2 = y1 + h;
                shp = new line(x1, y1, c_rand, x2, y2);

            }
            break;
            case 1://rect
            {
                int w = randGen.nextInt(201);
                int h = randGen.nextInt(201);
                boolean isFilled = randGen.nextBoolean();
                shp = new rectangle(x1, y1, c_rand, x1, y1, isFilled);
            }
            break;
            case 2://oval
            {
                int w = randGen.nextInt(201);
                int h = randGen.nextInt(201);
                boolean isFilled = randGen.nextBoolean();
                shp = new Oval(h, w, isFilled, x1, y1, c_rand);
            }
            break;

        }

        //I have a random shape now
        paintpanel.addshape(shp);
        paintpanel.repaint();

    }
}
