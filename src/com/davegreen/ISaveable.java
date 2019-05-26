package com.davegreen;

import java.util.List;

public interface ISaveable
{
    // Remember in an Interface you only provide methods that the implementing classes HAVE TO have.
    
    List<String> write();                   // Return type List<String>
    
    
    void read(List<String> savedValues);    // Void return, however the method has a parameter called saveValues of type List<String>.
}
