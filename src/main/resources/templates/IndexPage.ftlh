<#import "./common.ftlh" as c>

<@c.page>
    <div class="datatable">
        <div class="caption">Tests</div>
        <table>
            <thead>
            <tr>
                <th>Content</th>
                <th>Hash</th>
                <th>Answer</th>
            </tr>
            </thead>
            <tbody>
            <#list tests as test>
            <tr>
                <td>${test.getContent()}</td>
                <td>${test.getHash()}</td>
                <td><#if test.getAnswer()??>${test.getAnswer()}<#else>No answer</#if></td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>