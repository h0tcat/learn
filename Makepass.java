import java.util.Scanner;
import java.util.Random;

public class Makepass
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		//���͂��󂯂�
		int len = 0;
		while(true)
		{
			System.out.println("�p�X���[�h�̌��������");
			try {
				len = Integer.parseInt(scan.next());
				scan.close();
				break;
			}catch(NumberFormatException e) {
				System.out.println("�����œ��͂��Ă�������");
				continue;
			}
		}

		int i = 0;
		int passint[] = new int[len];
		
		while(i < len) {  //�����𔭐�
			Random random = new Random();
			int rand = random.nextInt(122)+48;

			if(rand >= 48 && rand <= 57 || rand >= 65 && rand <= 90 || rand >= 97 && rand <= 122) {
				passint[i] = rand;

				i++;
			}
		}
		
		//int to byte
		byte passbyte[] = new byte[len];
		for(i = 0; i < len; i++){
			passbyte[i] = (byte)passint[i];
		}
		
		//byte to String
		String pass = "";
		try {
            pass = new String(passbyte, "US-ASCII");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
		
		System.out.println(pass);
	}
}