import java.util.Scanner;
import java.util.Random;

public class Makepass
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		final int Asc_0 = 48;
		final int Asc_9 = 57;
		final int Asc_A = 65;
		final int Asc_Z = 90;
		final int Asc_a = 97;
		final int Asc_z = 122;

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
		char[] pass = new char[len];
		
		while(i < len) {
			Random random = new Random();
			int rand = random.nextInt(122)+48;  //�����𐶐�

			if(rand >= Asc_0 && rand <= Asc_9 || rand >= Asc_A && rand <= Asc_Z || rand >= Asc_a && rand <= Asc_z) {
				pass[i] = (char)rand;  //�����ɕϊ�

				i++;
			}
		}
		
		System.out.println(pass);
	}
}