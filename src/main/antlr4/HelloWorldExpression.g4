grammar HelloWorldExpression;

@header {
    package org.charlesStockman.designPatterns.structural.interpreter;
}
/**
 * Parser
 */
expr: NUMBER OPERATOR NUMBER;

/**
 * LEXER
 */
OPERATOR:       [+-]+;

NUMBER:         [0-9];

WHITE_SPACE:    [ ]+;




