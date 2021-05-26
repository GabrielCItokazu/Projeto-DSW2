# Sistema de Promoções de Hoteis

### Sistema para criação de promoções de quarto de hotel em sites de reservas

Projeto realizado na disciplina de Desenvolvimento de Software para Web 2, do Departamento de Computação da UFSCar.

## Como executar

* Criar o banco de dados e usuário:
	* Executar no terminal em ordem:
		* $ sudo mysql -u root -p
		* \> create database SistemaHotel;
		* \> use SistemaHotel;
		* \> create user 'user'@'localhost' identified by 'Us3rl0c4lh0st10@';
		* \> grant all privileges on \*.\* to 'user'@'localhost';
		* \> flush privileges;
		* \> quit
		* $ sudo service mysql restart
* Rodar o sistema:
	* $ mvn spring-boot:run
