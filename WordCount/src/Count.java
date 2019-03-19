import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader; 

import java.io.IOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.io.FileWriter;
import java.util.Scanner; 

import java.util.TreeMap;
import java.util.Map.Entry;
import java.io.IOException;
 


public class Count

{ 
 
 
	static Scanner in = new Scanner(System.in);

    public static void main(String[] args)throws IOException

    {  
    	Map<String, Integer> map = new TreeMap<String, Integer>();//<����:��Ƶ>
		BufferedReader a = new BufferedReader(new FileReader("hali.txt"));// ��ȡҪ������ļ�

            String value= a.readLine();

            while (value!= null) //���������

            {

            	String[] words = value.split("[�� $ % & * @ ��.��,\"!--;:?��\']"); 

            	for (int i = 0; i < words.length; i++) //����д��ĸת��ΪСд��ĸ

            	{

                      String key = words[i].toLowerCase();

                	  if (key.length() > 0) 

                	  {

                      		if (!map.containsKey(key))//��һ�γ��֣�Ϊ1. 

                      		{

                          		map.put(key, 1);	

                      		} 

                      		else 

                      		{ 

                      			int k = map.get(key)+1;//���ǵ�һ�γ��֣��Ͱ�kֵ+1

                                map.put(key, k);

                          	}

                      }

                } 

                value = a.readLine();

            }while(true)

    		{

            	System.out.println("--------�˵�----------------");

        		System.out.println("s:ͳ��ĳ����Ƶ������������״ͼ��");

        		System.out.println("c:ͳ�Ƶ��������������");

        		System.out.println("q:ͳ�Ƹ��ı����е�����������Ƶ����������ļ�result.txt");
        	

        		System.out.println("                      ");

    			Scanner in = new Scanner(System.in);

    			System.out.println("��ѡ��ָ��:");

    			String order = in.nextLine();

    			switch(order)

    			{

    			case"c":Continuous(map);   break;      //ͳ�Ƶ������������
    			case"q":Mmmm(map);   break;      //ͳ�Ƹ��ı����е�����������Ƶ�������ܽ����ʼ���Ƶ�����ֵ�˳��������ļ�result.txt
    			case"s":Nnnn(map);   break;      //ͳ��ĳ����Ƶ������������״ͼ
    			

    			}

    		}
            
    }
    
	
	private static void Nnnn(Map<String, Integer> map) {
    	  System.out.println("Please input you want find word:\n");

          String string = in.nextLine();

          String[] word= string.split(","); //���ʺ͵���֮���ã�����

          float sum;

          for(int i=0; i<word.length; i++) 

          {

          	for(Map.Entry<String,Integer> w : map.entrySet()) 

          	{ 

          		if(word[i].equals(w.getKey()))

          		{  

          			System.out.println("����"+w.getKey() + "���ִ�����" + w.getValue());

          			sum=(float)(w.getValue())/100; 

          			for(int j=0;j<sum;j++)

          			{

          				System.out.print("#");//��#��������״ͼ,һ��#����100��

          			}

          			System.out.println();

          		}  

              } 

          }
		
	}
	private static void Mmmm(Map<String, Integer> map) throws IOException {
		 

        File file = new File("result.txt");

        FileWriter r = new FileWriter(file.getAbsoluteFile());

        for(Entry<String,Integer> w: map.entrySet()) 

        {

        	r.write(w.getKey() + "  :  " + w.getValue()+"  \n");

        }

        r.close();
        System.out.println("���д���ļ�");
		
	}
	public static void SortMap(Map<String,Integer> oldmap){
		ArrayList<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(oldmap.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2){
				return o2.getValue() - o1.getValue();//����
			}
		});
		for(int i = 0; i<list.size(); i++){  

            System.out.println(list.get(i).getKey()+ ": " +list.get(i).getValue());
	    }
	}
    public static void Continuous(Map<String,Integer> wordscount2) {
    	 SortMap(wordscount2); //��ֵ�������� 
	}
}