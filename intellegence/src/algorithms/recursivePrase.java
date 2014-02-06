package algorithms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class recursivePrase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String prasingString ="";
		try{
			System.out.println("Pleas input the sentence");
			BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
			prasingString = "(((125/5)-5)/10)+(15/5)";//readerConsole.readLine();
			String result = evalute(prasingString);
			System.out.println(result);
			/*String [] bufferingEval = prasingString.split("[\\( \\)]") ;
			Stack<String> evalStrings = new Stack<String>();
			for(String str:bufferingEval)
			{
				System.out.println(str);
				evalStrings.push(str);
			}
			String bufStrign ="";
			while(!evalStrings.empty())
			{
				String sentence = evalStrings.pop();
				bufStrign = resultSentence(sentence+bufStrign);
			}
			System.out.println(bufStrign);*/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static String evalute(String input)
	{
		String result ="";
		String express = "";
		for(int i=0; i<input.length();i++)
		{
			if(input.charAt(i)==')')
			{
				express = input.substring(0, i);
				input=resultSentence(express)+input.substring(i+1);
				break;//i=0;
			}
			if(input.charAt(i)=='(')
			{
				input = input.substring(0,i)+evalute(input.substring(i+1));
				i=0;
			}
		}
		//result = resultSentence(express);
		return resultSentence(input);
	}
	
	public static String resultSentence (String inputSentence){
		String result = "";
		double resultDouble =0;
		String []values = inputSentence.split("[-+*/=]");
		String sing= inputSentence.replaceAll("[1234567890.]", "");
		if(sing.equals("+"))
			resultDouble = Double.valueOf(values[0])+Double.valueOf(values[1]);
		else if (sing.equals("-"))
			resultDouble = Double.valueOf(values[0])-Double.valueOf(values[1]);
		else if (sing.equals("*"))
			resultDouble = Double.valueOf(values[0])*Double.valueOf(values[1]);
		else if (sing.equals("/"))
			resultDouble = Double.valueOf(values[0])/Double.valueOf(values[1]);
		else
			return inputSentence;
			
		return String.valueOf(resultDouble);
		
		
	}

}
