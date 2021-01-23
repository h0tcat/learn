#include "Rot13.h"

nori::Rot13::Rot13(){
	std::cout << "--- Rot13サンプルプログラム ---" << std::endl;
}

std::string nori::Rot13::Convert(char* plainText){
	
	this->wordSize=strlen(plainText);
	char wordBuffer[2];

	for(int i=0;i<this->wordSize;i++){
		this->wordAsciiCode = plainText[i];

		if(this->wordAsciiCode>='A' && this->wordAsciiCode<='Z'){
			this->wordAsciiCode += 13;

			if(this->wordAsciiCode >= '[')
				this->wordAsciiCode-=26;
		}else if(this->wordAsciiCode>='a' && this->wordAsciiCode<='z'){
			this->wordAsciiCode += 13;
			if(this->wordAsciiCode>='{')
				this->wordAsciiCode -= 26;
		}
		wordBuffer[0]=(char)this->wordAsciiCode;
		wordBuffer[1]='\0';

		this->word.append(wordBuffer);

	}
	return this->word;
}
