node('master'){
	git 'https://github.com/franciscofnneto/DevOps.git'
	bat 'mvn verify'
}