package by.htp.controller.action.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProcessorsSingleton
{
    private static List<IActionProcessor> PROCESSORS;
    
    public static synchronized List<IActionProcessor> getProcessors()
    {
        if(PROCESSORS == null)
        {
            List<IActionProcessor> temp = new ArrayList<>();
            temp.add(new SearchBookActionProcessor());
            temp.add(new UploadFileToServActoinProcessor());
            temp.add(new ToEditBookPageActionProcessor());
            temp.add(new OpenBookPageActionProcessor());
            temp.add(new OutputAllBookActionProcessor());
            temp.add(new DeleteActionProcessor());
            temp.add(new AddBookActionProcessor());
            temp.add(new AutorizateActionProcessor());
            temp.add(new EditActionProcessor());
            temp.add(new DeleteActionProcessor());
            PROCESSORS = Collections.unmodifiableList(temp);
            System.out.println("list processor  " + temp.size());
        }
        return PROCESSORS;
    }
}
