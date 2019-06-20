install:
	mvn install -Dmaven.test.skip=true
	
run-all:
	docker-compose up -d