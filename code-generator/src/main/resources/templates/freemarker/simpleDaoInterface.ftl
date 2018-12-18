<#if package?? && package != "">
package ${package};
</#if>
import java.util.*;
import ${entityPackageName}.${entityFileName};

/**
 * @author sjh
 */
public interface ${fileName} {

    public List<${entityFileName}> select${entityFileName}(${entityFileName} ${entityFileName?uncap_first});

    public int add${entityFileName}(${entityFileName} ${entityFileName?uncap_first});

    public int update${entityFileName}(${entityFileName} ${entityFileName?uncap_first});

    public int delete${entityFileName}(${entityFileName} ${entityFileName?uncap_first});

}