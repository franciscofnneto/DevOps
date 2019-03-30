node {
stage('Build') {
env.DEBUG_FLAGS = '-g'
echo 'Building..'
deleteDir()
checkout scm
sh 'cat The_Weather_Channel/Jenkinsfile_Francisco_Ferreira.md'
}
stage('Test') {
echo 'Testing..'
def ambiente = input id: 'test', message: 'Please Provide Parameters', ok: 'Next',
parameters: [
choice(name: 'ENVIRONMENT',
choices: ['dev','qa'].join('\n'),
description: 'Please select the Environment'),
string(name: 'TAG',
defaultValue: 'tag01',
description: 'Please enter the tag')
]
echo “${ambiente}"
}
stage('Deploy') {
echo 'Deploying....'
}
}