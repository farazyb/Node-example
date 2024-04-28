job('NodeJS example') {
    scm {
        git {
            remote {
                url('https://github.com/farazyb/node-example.git')
                credentials('farazyb') // Use if Jenkins uses credentials ID, otherwise remove this line
            }
            branch('dlsJob')
            userRemoteConfigs {
                gitConfigName('farazyb')
                gitConfigEmail('farazyazdanib@gmail.com')
            }
        }
    }
    triggers {
        scm('H/5 * * * *') // Poll SCM every 5 minutes
    }
    wrappers {
        nodejs('NodeJs') // Ensure this matches the name of the NodeJS installation in Jenkins configuration
    }
    steps {
        shell("npm install")
    }
}