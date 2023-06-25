# pizza-toppings


#SUMMARY

В приложении осталась проблема с совместной работай MapStruct, Spring и Lombook. Использовал разные плагины, но подружить с Kotlin не получилось.
При конфигурация, как в ветке "kotlin", kotlin-maven-plugin(без допплагинов) -
у меня генерировались классы маперов, создавались все бины(контроллеры, сервисы, мапперы) и ложились в контейнер.
Но добиться инжектирования бинов мапперов в сервисы не получилось. 
Проблема в Lombook и MapStruct требует более длительного иследования и понимания, как создаются бины в Java и Kotlin
Перед началом работы над проектом, я пробовал создавать pet-project на Kotlin и конвертировать проект с Java - 
все работало отлично, но  без Lombook и MapStuct. Поэтому в этой ветке я исключил эти технологии, чтобы добиться рабочей версии.

Приведу пример kotlin-maven-plugin с плагинами, которым пробовал решить проблему в ветке "kotlin". Но при его использоании не происходит 
генерация классов маперов.

<plugin>
				<groupId>org.jetbrains.kotlin</groupId>
				<artifactId>kotlin-maven-plugin</artifactId>
				<version>${kotlin.version}</version>
				<configuration>
					<args>
						<arg>-Xjsr305=strict</arg>
					</args>
					<compilerPlugins>
						<plugin>spring</plugin>
						<plugin>jpa</plugin>
						<plugin>lombok</plugin>
					</compilerPlugins>
				</configuration>
				<executions>
					<execution>
						<id>compile</id>
						<goals>
							<goal>compile</goal>
						</goals>
					</execution>
					<execution>
						<id>kapt</id>
						<goals>
							<goal>kapt</goal>
						</goals>
						<configuration>
							<sourceDirs>
								<sourceDir>${project.basedir}/src/main/kotlin</sourceDir>
								<sourceDir>${project.basedir}/src/main/java</sourceDir>
							</sourceDirs>
							<annotationProcessorPaths>
								<annotationProcessorPath>
									<groupId>org.mapstruct</groupId>
									<artifactId>mapstruct-processor</artifactId>
									<version>${mapstruct.version}</version>
								</annotationProcessorPath>
								<annotationProcessorPath>
									<groupId>org.projectlombok</groupId>
									<artifactId>lombok</artifactId>
									<version>${lombok.version}</version>
								</annotationProcessorPath>
								</annotationProcessorPaths>
						</configuration>
					</execution>
				</executions>
				<dependencies>
					<dependency>
						<groupId>org.jetbrains.kotlin</groupId>
						<artifactId>kotlin-maven-allopen</artifactId>
						<version>${kotlin.version}</version>
					</dependency>
					<dependency>
						<groupId>org.jetbrains.kotlin</groupId>
						<artifactId>kotlin-maven-noarg</artifactId>
						<version>${kotlin.version}</version>
					</dependency>
					<dependency>
						<groupId>org.jetbrains.kotlin</groupId>
						<artifactId>kotlin-maven-lombok</artifactId>
						<version>${kotlin.version}</version>
					</dependency>
				</dependencies>
			</plugin>