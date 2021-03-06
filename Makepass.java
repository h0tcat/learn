import java.util.Scanner;
import java.util.Base64.Encoder;
import java.util.Random;
import java.util.ArrayList;
import java.util.Base64;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;	

public class Makepass
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		//定数を宣言（Asciiコード）
		final int Asc_exc = '!';
		final int Asc_0 = '0';
		final int Asc_z = 'z';
		final int Asc_tilde = '~';

		//入力を受ける
		int len = 0;
		String mark = "";
		while(true)
		{
			try {
				System.out.println("パスワードの桁数を入力");
				len = Integer.parseInt(scan.next());
				break;
			}catch(NumberFormatException e) {
				System.out.println("数字で入力してください");
				continue;
			}
		}

		System.out.println("記号：有_y   無_n");
		while(true){
			mark = scan.next();
			if(mark.matches("[yYnN]"))
				break;
			else
				System.out.println("yかnで入力してください");
		}
		scan.close();

		StringBuilder pass = new StringBuilder();

		Random random = new Random();
		//記号ありのパスワード生成
		
		if(mark.matches("[yY]")){

			for(int j=0;j<len;j++){	
				for(int i=0;i<len;i++){
					int rand = random.nextInt(Asc_tilde) + Asc_exc;
					pass.append((char)rand);
				}
			}
		}
		//記号なしのパスワード生成
		else if(mark.matches("[nN]")){
			boolean isAscii;

			for(int j=0;j<4;j++){	
				for(int i=0;i<len;i++){
					int rand = random.nextInt(Asc_z) + Asc_0;
					isAscii = String.valueOf((char)rand).matches("[a-zA-Z_0-9]"); // Asciiかどうか

					if(isAscii)
						pass.append((char)rand);
				};
			}
		}		

		try {
			byte[] passBytes = pass.toString().getBytes(StandardCharsets.UTF_8);
			Encoder base64Encoder=Base64.getEncoder();

			String result=new String(base64Encoder.encode(passBytes),StandardCharsets.UTF_8);
			System.out.println(result);
		} catch (Exception e){
			e.printStackTrace();
		}

	}
}
