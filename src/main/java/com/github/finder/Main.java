package com.github.finder;

import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.CmdLineException;

public class Main{
    public Main(String[] arguments)
    {
        Args args = parseArguments(arguments);
        Finder finder = new Finder(args);
        
        for(String base: args)
        {
            String[] items = finder.find(base);
            for(String item: items)
            {
                System.out.println(item);
            }
        }
    }
    private Args parseArguments(String[] arguments)
    {
        Args args = new Args();
        try
        {
            CmdLineParser parser = new CmdLineParser(args);
            parser.parseArgument(arguments);
        }
        catch (CmdLineException e)
        {
             System.out.println(e);
			throw new CmdLineException (e)
        }
        return args;
        
        
    }

    public static void main(String[] args)
    {
        //Mainクラスのコンストラクタを呼び出す
        new Main(args);
        
    }
}
