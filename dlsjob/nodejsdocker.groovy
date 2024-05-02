job('NodeJS example') {
    scm {
        git {
            remote {
                url('https://github.com/farazyb/node-example.git')
                credentials('farazyb')  // Ensure this ID matches an existing credentials ID in Jenkins
            }
            branch('master')
        }
    }
    triggers {
        scm('H/5 * * * *')  // Poll SCM every 5 minutes
    }
    wrappers {
        nodejs('NodeJs')  // Make sure 'NodeJs' exactly matches the name in Jenkins configuration
    }
       steps {
        dockerBuildAndPublish {
            repositoryName('farazyb75/farazyb75/docker-nodejs-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}