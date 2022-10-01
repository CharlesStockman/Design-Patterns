//package org.charlesStockman.designPatterns.structural.interpreter;
//
//import lombok.*;
//import org.antlr.v4.runtime.CharStreams;
//import org.antlr.v4.runtime.CommonTokenStream;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import java.util.*;
//import java.util.stream.Stream;
//
///**
// * This Test is different from other Unit Test.  It will generate the code from BNF File that the user generates
// * and ANTLR will product java files from.  I don't consider this part of integration test since code is being tested
// * and no resources are configured.
// *
// * Once the Configuration File is test the functions that user created to parse the input with the knowledge that the
// * code generated from the BNF is correct.  Also, the BNF is on your system where a database can on a remote machine.
// * That is why I am considering the creation of the code form the BNF to be part of the compiler test
// *
// * An example of paramatized test where a function will return a stream of test that will be executed for each
// * function with the annotation
// */
//public class InterpreterTest {
//
//    @AllArgsConstructor
//    @ToString
//    private static class TestData {
//
//        @Getter
//        @Setter
//        private String expression;
//
//        @Getter
//        @Setter
//        private Long answer;
//    }
//
//    @AllArgsConstructor
//    @ToString
//    private static class TestLexer {
//        @Getter
//        @Setter
//        private String expression;
//
//        @Getter
//        @Setter
//        private Set<String> tokens = new HashSet<>();
//    }
//
//    /**
//     *
//     */
//    @ParameterizedTest(name = "{0}")
//    @MethodSource("TestLexerProvider")
//    void testLexer(TestLexer arg) {
//        //System.out.println("The string is " + arg);
//        //System.out.println("The length of the expression is " + arg.getExpression().length());
//        //System.out.println("The expression is " + arg.getExpression());
//        HelloWorldExpressionLexer lexer =
//                new HelloWorldExpressionLexer(CharStreams.fromString(arg.getExpression()));
//        //System.out.println("Lexer = " + lexer.getToken().getText());
//        CommonTokenStream stream = new CommonTokenStream(lexer);
//        //System.out.println("Token String = " + stream.getTokens());
//    }
//
//    // this need static
//    static Stream<TestLexer> TestLexerProvider() {
//        return Stream.of(
//                new TestLexer("2 + 3", Set.of("2","+", "3")),
//                new TestLexer("3 - 2,", Set.of("3","-","2")),
//                new TestLexer("2+5", Set.of("5","+","2"))
//        );
//    }
//}
