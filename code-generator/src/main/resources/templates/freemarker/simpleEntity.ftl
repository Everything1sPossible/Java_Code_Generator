<#if package?? && package != "">
package ${package};
</#if>
import java.util.*;

/**
 * @author sjh
 */
public class ${fileName} {
    <#if fields?exists>
        <#list fields?keys as fieldName>
    private ${fields[fieldName]} ${fieldName};
        </#list>
    </#if>
    <#if fields?exists>
        <#list fields?keys as fieldName>
    public ${fields[fieldName]} get${fieldName}() {
        return ${fieldName};
    }

    public void set${fieldName}(${fields[fieldName]} ${fieldName}) {
        this.${fieldName} = ${fieldName};
    }
        </#list>
    </#if>
}