# GSONKGADAPTER

Gson is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object. Gson can work with arbitrary Java objects including pre-existing objects that you do not have source-code of.
There are a few open-source projects that can convert Java objects to JSON. However, most of them require that you place Java annotations in your classes; something that you can not do if you do not have access to the source-code. Most also do not fully support the use of Java Generics. Gson considers both of these as very important design goals.
This library for adapter GSON
## Usage

Add it in your root build.gradle at the end of repositories:

```

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

```

Step 2. Add the dependency

```

	dependencies {
	        implementation 'com.github.KutuGondrong:gsonkgadapter:1.0.0'
	}

```
## Goals

Provide simple toJson() and fromJson() methods to convert objects to JSON

## Website
[kutugondrong.com](https://kutugondrong.com/)
