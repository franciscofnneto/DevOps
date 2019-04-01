def ambiente = input id: 'test', message: 'Please Provide Parameters', ok: 'Next',
parameters: [
choice(name: 'Selecione uma Opção',
choices: ['Opção 001','Opção 002'].join('\n'),
description: 'Escolha uma Opção'),
string(name: 'TAG',
defaultValue: 'tag01',
description: 'Entre com a tag')
]
node {
stage('Build') {
env.DEBUG_FLAGS = '-g'
echo 'Building..'
echo '${ambiente}'
deleteDir()
checkout scm
sh 'cat The_Weather_Channel/Jenkinsfile_Francisco_Ferreira.md'
sh 'printenv'
}
stage('Test') {
echo 'Testing..'
pom = readMavenPom file: 'The_Weather_Channel/pom.xml'
}
stage('Deploy') {
echo 'Deploying....'
}
}