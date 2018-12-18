<#if package?? && package != "">
package ${package};
</#if>
import java.util.*;

/**
 * @author sjh
 */
public class ${fileName} {
    <#if fields?exists>
        <#list fields?keys as key>
    private ${fields[key]} ${key};
        </#list>
    </#if>
    <#if fields?exists>
        <#list fields?keys as key>
    public ${fields[key]} get${key?cap_first}() {
        return ${key};
    }

    public void set${key?cap_first}(${fields[key]} ${key}) {
        this.${key} = ${key};
    }
        </#list>
    </#if>
}