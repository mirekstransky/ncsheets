[#ftl]
[#macro page title="NC Sheets"]
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="/css/general.css"/>
        <link rel="stylesheet" href="/css/style.css"/>
        <link rel="icon" type="image/x-icon" href="/images/favicon.png">
        <title>${title}</title>
    </head>
        <body>
            [#nested]
        </body>
    </html>
[/#macro]

[#macro totalCount]
    <div class="totalCount">
        [#if items.totalElements == 1]
            Celkem nalezen <strong>${items.totalElements}</strong> záznam.
        [#elseif items.totalElements <= 4]
            Celkem nalezeny <strong>${items.totalElements}</strong> záznamy.
        [#else ]
            Celkem nalezeno <strong>${items.totalElements}</strong> záznamů.
        [/#if]
    </div>
[/#macro]
[#macro pager]
[#--    <div class="pager">--]
    [@pagerLink page=items.number - 1 active=items.first text="←" /]
    [@pagerLink page=items.number + 1 active=items.last text="→" /]
[#--    </div>--]
[/#macro]

[#macro pagerLink page text active]
    [#if active]
        <div class="btn nopointer">${text}</div>
    [#else ]
        <a href="/components/holder?page=${page}&size=${items.size}" class="btn btn--full">${text}</a>
    [/#if]
[/#macro]