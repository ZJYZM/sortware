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
    	Map<String, Integer> map = new TreeMap<String, Integer>();//<单词:词频>
		BufferedReader a = new BufferedReader(new FileReader("hali.txt"));// 读取要处理的文件

            String value= a.readLine();

            while (value!= null) //处理标点符号

            {

            	String[] words = value.split("[【 $ % & * @ 、.。,\"!--;:?】\']"); 

            	for (int i = 0; i < words.length; i++) //将大写字母转换为小写字母

            	{

                      String key = words[i].toLowerCase();

                	  if (key.length() > 0) 

                	  {

                      		if (!map.containsKey(key))//第一次出现，为1. 

                      		{

                          		map.put(key, 1);	

                      		} 

                      		else 

                      		{ 

                      			int k = map.get(key)+1;//不是第一次出现，就把k值+1

                                map.put(key, k);

                          	}

                      }

                } 

                value = a.readLine();

            }while(true)

    		{

            	System.out.println("--------菜单----------------");

        		System.out.println("s:统计某单词频数并画出其柱状图：");

        		System.out.println("c:统计单词数量并输出：");

        		System.out.println("q:统计该文本所有单词数量及词频数并输出到文件result.txt");
        	

        		System.out.println("                      ");

    			Scanner in = new Scanner(System.in);

    			System.out.println("请选择指令:");

    			String order = in.nextLine();

    			switch(order)

    			{

    			case"c":Continuous(map);   break;      //统计单词数量并输出
    			case"q":Mmmm(map);   break;      //统计该文本所有单词数量及词频数，并能将单词及词频数按字典顺序输出到文件result.txt
    			case"s":Nnnn(map);   break;      //统计某单词频数并画出其柱状图
    			

    			}

    		}
            
    }
    
	
	private static void Nnnn(Map<String, Integer> map) {
    	  System.out.println("Please input you want find word:\n");

          String string = in.nextLine();

          String[] word= string.split(","); //单词和单词之间用，隔开

          float sum;

          for(int i=0; i<word.length; i++) 

          {

          	for(Map.Entry<String,Integer> w : map.entrySet()) 

          	{ 

          		if(word[i].equals(w.getKey()))

          		{  

          			System.out.println("单词"+w.getKey() + "出现次数：" + w.getValue());

          			sum=(float)(w.getValue())/100; 

          			for(int j=0;j<sum;j++)

          			{

          				System.out.print("#");//用#来代替柱状图,一个#代表100次

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
        System.out.println("完成写入文件");
		
	}
	public static void SortMap(Map<String,Integer> oldmap){
		ArrayList<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(oldmap.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2){
				return o2.getValue() - o1.getValue();//降序
			}
		});
		for(int i = 0; i<list.size(); i++){  

            System.out.println(list.get(i).getKey()+ ": " +list.get(i).getValue());
	    }
	}
    public static void Continuous(Map<String,Integer> wordscount2) {
    	 SortMap(wordscount2); //按值进行排序 
	}
}