pipeline{
	agent any

	stages{

		stage('Compile Stage'){

			steps{

				withMaven(mavem: 'maven_3_6_0'){
					sh 'mvn clean install'
				}
			}
		}

		stage('Teste Stage'){

			steps{

				withMaven(mavem: 'maven_3_6_0'){
					sh 'mvn test'
				}
			}
		}

		stage ('Cucumber Reports'){

			steps{
				cucumber buildStatus: "UNSTABLE",
					fileIncludePattern: "**/cucumber.json",
					jsonReportDirectory: 'target'
			}
		}
	}
}