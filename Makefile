install:
	mvn install -Dmaven.test.skip=true

install-%:
	mvn install -Dmaven.test.skip=true -pl $*
	
build:
	docker-compose build
	
container-all-up:
	docker-compose up -d

build-run-all:
	make install
	make build
	make container-all-up

just-run:
	make container-all-up

ibr-%:
	mvn install -Dmaven.test.skip=true -pl $*
	docker-compose build $*
	docker-compose up $*
	
run-%:
	docker-compose up -d $*