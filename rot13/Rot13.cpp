#include "Rot13.h"

nori::Rot13::Rot13(){
	std::cout << "--- Rot13サンプルプログラム ---" << std::endl;
}

std::string nori::Rot13::Convert(char* plainText){
	
	this->wordSize=strlen(plainText);
	 
	for(int i=0;i<this->wordSize;i++){
		this->wordAsciiCode = plainText[i];
		this->wordAsciiCode>='A' && this->wordAsciiCode<='Z';


		this->isAtoZ = this->wordAsciiCode>='A' && this->wordAsciiCode<='Z';
		this->is_aToz = this->wordAsciiCode>='a' && this->wordAsciiCode<='z';

		if(this->isAtoZ){
			this->wordAsciiCode += 13;

			if(this->wordAsciiCode >= '[')
				this->wordAsciiCode-=26;
		}else if(this->is_aToz){
			this->wordAsciiCode += 13;
			if(this->wordAsciiCode>='{')
				this->wordAsciiCode -= 26;
		}
		this->wordBuffer[0]=(char)this->wordAsciiCode;
		this->wordBuffer[1]='\0';

		this->word.append(this->wordBuffer);

	}
	return this->word;
}
