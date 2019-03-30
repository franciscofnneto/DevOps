node {
	stage('Build') {
		echo 'Building..'
		deleteDir()
		checkout scm
		sh 'cat README.md'
	}
	stage('Test') {
		echo 'Testing..'
	}
	stage('Deploy') {
		echo 'Deploying....'
	}
}