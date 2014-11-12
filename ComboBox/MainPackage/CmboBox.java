package MainPackage;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CmboBox {

		
	HashMap<Integer, String> MONTHS = new HashMap();
	
	/*
	 * The second Combo Box is for day of the month.
	 * Add a combo box item for each day of the month
	 */
	public static  String[] DAYS = {"1", "2", "3", "4", "5", 
	"6", "7", "8", "9", "10", "11", 
  "12", "13", "14", "15", "16", "17", 
  "18", "19", "20", "21", "22", "23", 
  "24", "25", "26", "27", "28", "29", 
  "30", "31"};
	
	/*
	 * The third Comb Box is the year. 
	 * Add a year for the last prior five years, 
	 * the current five years, and the next five years
	 */
	public static  int[] YRS = {2009, 2010, 2011, 2012,
		2013, 2014, 2015, 2016, 2017, 2018, 2019};
	
	private JFrame frame;

	//Launch the application
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					CmboBox Win = new CmboBox();
					
					Win.frame.setVisible(true);
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}

	//Make the application
	public CmboBox() {
		
		initialize();
	}

	/*
	 * The first Combo Box, have a combo box 
	 * item for each month in the year. 
	 * The value should be the number of 
	 * the month, the text should be the name 
	 * of the month
	 */
	//Initialize frame contents
	private void initialize() {
		
		Scanner input= new Scanner(System.in);
		
		frame = new JFrame();
		
		frame.setBounds(100, 100, 450, 300);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(null);
		
		MONTHS.put(1, "January");
		
		MONTHS.put(2, "February");
		
		MONTHS.put(3, "March");
		
		MONTHS.put(4, "April");
		
		MONTHS.put(5, "May");
		
		MONTHS.put(6, "June");
		
		MONTHS.put(7, "July");
		
		MONTHS.put(8, "August");
		
		MONTHS.put(9, "September");
		
		MONTHS.put(10, "October");
		
		MONTHS.put(11, "November");
		
		MONTHS.put(12, "December");

		Calendar Current= Calendar.getInstance();
		
		int mnth= Current.get(Calendar.MONTH)+1;
		
		int day= Current.get(Calendar.DATE);
		
		final int year= Current.get(Calendar.YEAR);
		
		System.out.println(year);
		
		System.out.println(mnth);
		
		System.out.println(day);
		
		for(int i=1; i<MONTHS.size()+1; i++){
			
		System.out.println(MONTHS.get(i));
		}
		
		final JComboBox comboBox = new JComboBox();
		
		comboBox.setBounds(167, 54, 120, 20);
		
		frame.getContentPane().add(comboBox);
		
		for(int i=1; i<MONTHS.size()+1; i++){
			
			comboBox.addItem(MONTHS.get(i));
			
		}

		final JComboBox cmbox1 = new JComboBox();
		
		cmbox1.setBounds(167, 106, 60, 20);
		
		frame.getContentPane().add(cmbox1);
		
		for (int i=0; i<DAYS.length; i++){
			
			cmbox1.addItem(DAYS[i]);
		}
		
		JComboBox comboBox_2 = new JComboBox();
		
		comboBox_2.setBounds(167, 158, 90, 20);
		
		frame.getContentPane().add(comboBox_2);
		
		for (int i=0; i<YRS.length; i++){
			
			comboBox_2.addItem(YRS[i]);
		}
		
	for (int i=1; i<MONTHS.size()+1;i++){
		
		if (mnth== i){
			
			comboBox.setSelectedItem(MONTHS.get(i));
		}
	}
	
	for (int i=0; i<DAYS.length;i++){
		
		if (day== i){
			
			cmbox1.setSelectedItem(DAYS[i-1]);
		}
	}

	for (int i=0; i<YRS.length;i++){
		
		if (year== YRS[i]  ){
			
			comboBox_2.setSelectedItem(YRS[i]);
		}
	}
	
		comboBox.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            Object picked = comboBox.getSelectedItem();
            
            if (picked.toString()=="November" || 
            		
            		picked.toString()=="September" ||
            		
            		picked.toString()=="June"
            		
                    || picked.toString()=="April"){
            	     
                    cmbox1.removeAllItems();
                    
                    for (int x=0; x<DAYS.length -1;x++){
                    	
                    	cmbox1.addItem(DAYS[x]);
                    }
                    }
                  
                            
                    else if (picked.toString()=="January" || picked.toString()=="March"
                    		
                    		|| picked.toString()=="May"
                    		
                    || picked.toString()=="July"  || picked.toString()=="August"  
                    
                    || picked.toString()=="October"
                    
                    || picked.toString()=="December"){
                    	
                                   cmbox1.removeAllItems();
                                   
                                    for (int x=0; x<DAYS.length;x++){
                                    	
                                    	cmbox1.addItem(DAYS[x]);
                                    }}  
         //Leap Year check
             else if((year % 4 == 0) && year % 100 != 0){
            	 
        		if(picked.toString()=="February" ){
        			
                    cmbox1.removeAllItems();
                    
                    for (int x=0; x<DAYS.length -2;x++){
                    	
                    	cmbox1.addItem(DAYS[x]);
            }}}
            else if ((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0))
            {
            	if(picked.toString()=="February" ){
            		
                    cmbox1.removeAllItems();
                    
                    for (int x=0; x<DAYS.length -2;x++){
                    	
                    	cmbox1.addItem(DAYS[x]);	
        
            }}}
            
            else 
            {

                      cmbox1.removeAllItems();
                      
                      for (int x=0; x<DAYS.length -3;x++){
                    	  
                      	cmbox1.addItem(DAYS[x]);
                      }}
            
            } });      		
	
		//Labels for the combo boxes
		JLabel mnthLabel = new JLabel("Month");
		
		mnthLabel.setBounds(111, 57, 46, 14);
		
		frame.getContentPane().add(mnthLabel);
		
		JLabel yrLabel = new JLabel("Year");
		
		yrLabel.setBounds(111, 161, 46, 14);
		
		frame.getContentPane().add(yrLabel);
		
		JLabel dayLabel = new JLabel("Day");
		
		dayLabel.setBounds(111, 109, 46, 14);
		
		frame.getContentPane().add(dayLabel);
	}
 }