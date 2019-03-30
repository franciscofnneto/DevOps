def username = 'Jenkins'
env.CC = 'clang'
def ambiente = input id: 'test', message: 'Please Provide Parameters', ok: 'Next',
parameters: [
choice(name: 'ENVIRONMENT',
choices: ['dev','qa'].join('\n'),
description: 'Please select the Environment'),
string(name: 'TAG',
defaultValue: 'tag01',
description: 'Please enter the tag')
]
node {
stage('Build') {
env.DEBUG_FLAGS = '-g'
echo 'Building..'
echo "Hello Mr. ${username}"
echo "Running ${env.JOB_NAME} (${env.BUILD_ID}) at ${env.JENKINS_URL}"
deleteDir()
checkout scm
sh 'cat The_Weather_Channel/Jenkinsfile_Francisco_Ferreira.md'
sh 'printenv'
}
stage('Test') {
echo 'Testing..'
echo “${ambiente}"
}
stage('Deploy') {
echo 'Deploying....'
}
}