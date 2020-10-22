//gitlab的凭证
def git_auth = "c696df5c-fbe7-4ec4-9274-80dfb58a3de3"

//构建版本的名称
def tag = "latest"

def project_name = "test1022"

def imageName = "${project_name}:${tag}"

pipeline {
    agent any

    stages {
        stage('pull code') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: "${git_auth}", url: 'https://github.com/nh666666/clouddemo.git']]])
            }
        }
    }
}
