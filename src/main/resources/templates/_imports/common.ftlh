[#ftl]
[#macro page title="NC Sheets"]
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="/css/general.css"/>
        <link rel="stylesheet" href="/css/style.css"/>
        <title>${title}</title>
    </head>
        <body>
            [#nested]
        </body>
    </html>
[/#macro]


[#macro totalCount]
    <div class="totalCount">
        [#if osoby.totalElements == 1]
            Celkem nalezen <strong>${osoby.totalElements}</strong> záznam.
        [#elseif osoby.totalElements <= 4]
            Celkem nalezeny <strong>${osoby.totalElements}</strong> záznamy.
        [#else ]
            Celkem nalezeno <strong>${osoby.totalElements}</strong> záznamů.
        [/#if]
    </div>


[/#macro]

[#macro pager]
[#--    <div class="pager">--]
        [@pagerLink page=blogy.number - 1 active=blogy.first text="←" /]
        [@pagerLink page=blogy.number + 1 active=blogy.last text="→" /]
[#--    </div>--]
[/#macro]

[#macro pagerLink page text active]
    [#if active]
        <span class="page active">${text}</span>
    [#else ]
            <a  href="${createURL({"size": blogy.size, "page": page})}" class="btn btn--full">${text}</a>
    [/#if]
[/#macro]