mkdir homework2
cd homework2
git init
git clone https://github.com/mih475/jpf-core.git
cd jpf-core
git remote show origin | grep "Fetch URL: " > test-execution.txt
echo SHA: $(git rev-parse HEAD) >> test-execution.txt
time ./gradlew buildJars >> test-execution.txt
cp test-execution.txt ../../

