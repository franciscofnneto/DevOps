node{
	stage('Build'){
	git url: 'https://github.com/franciscofnneto/DevOps.git'
	def mvnHome = tool 'M3'
	env.PATH = "${mvnHome}/bin:${env.PATH}"
	sh 'mvn -B verify'
}
}