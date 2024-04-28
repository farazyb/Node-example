job('NodeJS example') {
    scm {
        git {
            remote {
                url('https://github.com/farazyb/node-example.git')
                credentials('farazyb') // Ensures Jenkins uses the specified credentials ID for repository access
            }
            branch('master')
            // Correct method to set user config within git
            extensions {
                userRemoteConfig {
                    name('farazyb')
                    email('farazyazdanib@gmail.com')
                }
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