cd java
mvn versions:set -DnewVersion=$1
mvn versions:commit -Pci
cd ../web/lora-package
npm version $1
cd ../../nodejs
for d in `ls` ;do cd $d;npm version $1;cd ..;done