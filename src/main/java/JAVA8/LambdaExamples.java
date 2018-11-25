package JAVA8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.TooManyListenersException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class LambdaExamples {

    public static boolean isGreaterThan3(int number){
        return number>3;
    }

    public boolean isEven(int number){
        return number%2==0;

    }

    public static int compute(int number){
        return number*2;
    }

    public void streamExample(){
        List<Integer> numbers=Arrays.asList(1,2,34,56,7);
        numbers.stream()
                .filter(e -> e % 2==0) //take only even number
                .mapToInt(LambdaExamples:: compute)//double the numbers
                .sum();//sum it

        //if u want to parallelize it use parallel stream
        //this code will take less time to execute.
        //When to use parallel stream
        //when it make sense means problem is actually parallelizable
        // when u willing to spend more resource to get faster result.
        //when data size is big enough that u will get performance benefit
        //when task comutation is big enough that u will get performance benefit
        numbers.parallelStream()
                .filter(e -> e % 2==0) //take only even number
                .mapToInt(LambdaExamples:: compute)//double the numbers
                .sum();//sum it

        //stream is abstraction not data, data does not exist in stream its like non mutating pipeline.
        numbers.stream()
                .filter(e-> e%2==0)
                .map(e -> e*2.0)
                .reduce(0.0, (carry,num) ->carry+num);

        //------- filter------
        //no of elements in output is less than no of elements in input
        //parameter: Stream<T> filter takes Filter<T> as input

        //------map--------
        //map transorms value
        //no of output is equal to no of input.
        //no guarantee of type of o/p with respect to type of input
        //parameter:  Stream<T> map takes Function<T,R> to return Stream<R>

        //both filter and map stay within their swimlanes.

		/*         Filter    map      reduce
										0.0
			x1       |                 \
			--------------------------- \
			x2     ->        x2'	->	 +
			---------------------------   \
			x3      |                      \
			-----------------------------   \
			x4      ->       x4'       ->    +
		 */

        //reduce cut across the swimlanes
        //reduce convert stream to a single concrete value.
        //reduce on Stream<T> takes 2 parameters
        //first parameter is of type T
        //second parameter is of type BiFunction<R,T,R> to produce a result of R.

        //sum : a special reduce function
        numbers.stream()
                .filter(e-> e%2==0)
                .mapToDouble(e -> e*2.0)
                .sum();

        //collect: special reduce function

        //case: double the even values and put that into a list
        List<Integer> doubleList=new ArrayList<>();
        //wrong way to do this
        numbers.stream()
                .filter(e -> e%2==0)
                .map(e->e*2)
                .forEach(e -> doubleList.add(e));//dont do this as its shred mutability.
        //mutability is ok, sharing is nice but shred mutability is devil

        //good way is
        numbers.stream()
                .filter(e -> e%2==0)
                .map(e->e*2)
                .collect(toList());//same is toSet()

        //and toMap(key,value)
        numbers.stream()
                .filter(e -> e%2==0)
                .map(e->e*2)
                .collect(toMap(
                        e -> e,
                        e-> e*2
                ));

        //streams are lazily evaluated so it computes the intermediate operation only when termination operation is executed.
        //streams are efficient the computational complexity is same as old style code.
        //streams create pipelines of all intermediate functions and execute the whole pipleline one by one on each element of stream when a termination operation is triggered.

        //characteristics of stream  sized,ordered,distinct,sorted these can be controlled by the parent collection or can be done by calling various functions on stream.
        //infinite streams.
        //start with 100 create a series 100, 101, 102, 103...
        Stream.iterate(100,e ->e+1);
    }

    public void infiniteStreamExample(){
        //given a number k and a count n, find the total of double of
        //n even numbers starting with k , where sqrt of each number is >20
        int k=121;
        int n=51;
        compute(k,n);
    }

    public static int compute(int k, int n){
	/*	old style of code
 		int result=0;
		int index=k;
		int count=0;
		while(count>n){
			if(index %2==0 && Math.sqrt(index)>20){
				result+=index*2;
				count++;
			}
			index++;
		}
		return result;*/

        //code using lambda and streams
        return Stream.iterate(k, e -> e+1)   //unbounded ,lazy
                .filter(e -> e%2 == 0)	//unbounded ,lazy
                .filter(e -> Math.sqrt(e) > 20) //unbounded ,lazy
                .mapToInt(e -> e*2) //unbounded ,lazy
                .limit(n)   //bounded ,lazy
                .sum();			// it controls all above operations all above operation will execute when sum is called.
    }

    public void lambdaExample2(){
        //single abstract method interface can be changed to lambda
        Thread myThread=new Thread(() -> {
            System.out.println("This is another thrrad");
        });
        //before lambda in java 8 complier will create a .class file for each annonymous inner classes
        //so generated several inner class .class files like $1.class $2.class which increases the memory footprint of your application.

        //with lambda these inner classes class files not generated so they use concept invokedynamic : attach and detach function dynamically at run time using function pointer.
    }


    //lambdas should be glue code , it should be short, 2 lines are too many.
    public static void main(String[] args) {
        List<Integer> items=Arrays.asList(1,2,34,56,7);
        //type inference in lambda.
        items.forEach((item)->{
            item=item++;
        });

        //invoking function as we are just doing pass through so use method reference when we are just simply doing pass through.

        //=========When to use method reference===========

        //we can not use if we are manuplating data or if ambiguity of function like Integr.toString

        //-----case 1 -----
        items.forEach(e-> System.out.println(e));
        //in above code parameter becomes argument to a instance method so used method reference.
        //this example a method reference to instance method
        items.forEach(System.out::println);


        //-------case 2------
        items.forEach(e -> String.valueOf(e));
        //in above code parameter becomes argument to a static method so used method reference.
        items.forEach(String::valueOf);

        ///-----case 3-------
        items.forEach(e -> e.toString());
        //in above code your method parameter becomes target so used method reference.
        items.forEach(Integer :: toBinaryString);

        //----case 4------
        //two parameters as argument.
        items.stream().reduce(0,(total,num) -> Integer.sum(total, num));
        //here 2 parameter are used as simple pass through from parameter to argument to sum method total and num so this can be changed to method reference.
        items.stream().reduce(0,Integer::sum);

        //-----case 5----------
        //one parameter becomes target and other becomes argument
        items.stream().map(String:: valueOf).reduce("",(carry, str) -> carry.concat(str));
        //here carry becomes target and str becomes argument
        items.stream().map(String::valueOf).reduce("",String::concat);





        List<Integer> values=Arrays.asList(1,2,3,5,6,78,9,4);
        //find the double of first even number greater than 3
		/*
		 * Optional<Integer> desiredValue=values.stream().filter(e->e > 3)
						.filter(e-> e % 2==0)
						.map(e -> e*2)
						.findFirst();
		*/

        //here method reference is used.
        //Higher order functions : passing functions into a function.
        //lazy (here filter function is lazy) and composition
        Optional<Integer> desiredValue=values.stream().filter(LambdaExamples::isGreaterThan3)
                .filter(new LambdaExamples():: isEven )
                .map(e -> e*2)
                .findFirst();
        System.out.println(desiredValue.get());

        //these intermediate functions will not execute until we call a terminal operation like findFirst or collect or reduce.
        Stream<Integer> temp=values.stream().filter(LambdaExamples::isGreaterThan3)
                .filter(e-> e % 2==0)
                .map(e -> e*2);

        //now it will execute all intermediate functions.
        int executedNowValue=temp.findFirst().get();

        //replacing lambdas with Predicates.
        Predicate<Integer> iseven=num -> num %2 ==0;
        values.stream().filter(LambdaExamples::isGreaterThan3)
                .filter(iseven)
                .map(e -> e*2);

        //function returning predicates.
        Function<Integer, Predicate<Integer>> isGreaterThan=pivot -> numvalue -> numvalue > pivot;
        values.stream().filter(LambdaExamples::isGreaterThan3)
                .filter(isGreaterThan.apply(4))//so this work as number gt than 4, its a eager evaluation
                .map(e -> e*2);

        //Dependency Injection with Lambdas
        //so in above example we are injecting dependency in filter by injecting the various function strategy like gt than any number.
        //so filter uses it to filter the values.

        //initial conventional style
        totalValues(values);

        //now we want to total it based on some conditions(strategy)
        //still conventional style
        //totalValuesOnCondition(values, new EvenSelector());

        //calling it using declaratively
        totalValuesOnCondition(values, e -> e % 2==0);//passing evenSelector using lambda so here only passing essence.

        //calling functional style code
        totalValuesOnTestBoolean(values, () -> 0==0);//passing evenSelector using lambda so here only passing essence.

        //so how easy to change strategy now, here is strategy for summing number devisible by 3
        //so here we mixing object composition (Predicate) with function composition(creating functions for strategy while calling.)
        totalValuesOnPredicate(values, e -> e % 3==0);
        totalValuesOnPredicate(values, e -> true); //total all numbers

    }

    //imperative style of coding
    public static int totalValues(List<Integer> numbers){
        int result=0;
        for(int value:numbers){
            result+=value;
        }
        return result;
    }

    //total based on various strategy in conventional style
    public static int totalValuesOnCondition(List<Integer> numbers,Selector strategy){
        int result=0;
        for(int value:numbers){
            if(strategy.pick(value)){
                result+=value;
            }
        }
        return result;
    }

    //total based on various strategy in declarative(functional)  style
    public static int totalValuesOnPredicate(List<Integer> numbers,Predicate<Integer> strategy){

			/*int result=0;
			for(int value:numbers){
				if(strategy.test(value)){
					result+=value;
				}
			}
			return result;
			*/

        //all above code is the ceremonial code changing it to lambda style
        return numbers.stream()
                .filter(strategy)
                .reduce(0,Math::addExact);

    }

    //total based on various strategy in declarative(functional)  style
    public static int totalValuesOnTestBoolean(List<Integer> numbers,testBoolean testBoolean){

			/*int result=0;
			for(int value:numbers){
				if(strategy.test(value)){
					result+=value;
				}
			}
			return result;
			*/

        //all above code is the ceremonial code changing it to lambda style
        return numbers.stream()
                .filter(e -> testBoolean.test())
                .reduce(0,Math::addExact);

    }


    interface testBoolean{
        boolean test();
    }
    //its a strategy
    interface Selector{
        public boolean pick(int value);
    }

    class EvenSelector implements Selector{

        @Override
        public boolean pick(int value) {
            return value %2==0; //this is the essence of this class rest other code is ceremony so in lambda we only focus on essence.
        }

    }

    public static boolean isPrime(int number){

        Predicate<Integer> isDevisible=index -> number%index==0;

        return number>1 && IntStream.range(0, number).noneMatch(index -> number%index==0);
        //return number>1 && IntStream.range(0, number).noneMatch(index -> isDevisible(index));
    }
}