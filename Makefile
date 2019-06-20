install-all:
	mvn install -Dmaven.test.skip=true

install-%:
	mvn install -Dmaven.test.skip=true -pl $*
	
build-all:
	docker-compose build
	
install-build-all:
	make install-all
	make build-all
	
run-all:
	docker-compose up -d

ibr-%:
	mvn install -Dmaven.test.skip=true -pl $*
	docker-compose build $*
	docker-compose up $*
	
run-%:
	docker-compose up -d $*

kafka-create-topics:
	docker-compose exec kafka kafka-topics --create --topic subscriptions --partitions 1 --replication-factor 1 --if-not-exists --zookeeper localhost:32181
	docker-compose exec kafka kafka-topics --create --topic unsubscriptions --partitions 1 --replication-factor 1 --if-not-exists --zookeeper localhost:32181