
package gitbucket.core.repo.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object commentform extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template10[String,Option[String],Option[Int],Option[Int],Option[Int],Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean,Long,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(commitId: String,
  fileName: Option[String] = None,
  oldLineNumber: Option[Int] = None,
  newLineNumber: Option[Int] = None,
  issueId: Option[Int] = None,
  hasWritePermission: Boolean,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  focus: Boolean = false,
  uid: Long = new java.util.Date().getTime())(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*10.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(if(context.loginAccount.isDefined)/*11.36*/{_display_(Seq[Any](format.raw/*11.37*/("""
  """),_display_(if(!fileName.isDefined)/*12.27*/{_display_(Seq[Any](format.raw/*12.28*/("""<hr/><br/>""")))} else {null} ),format.raw/*12.39*/("""
  """),format.raw/*13.3*/("""<form method="POST" validate="true">
    <div class="panel panel-default issue-comment-box">
      <div class="panel-body">
        """),_display_(/*16.10*/gitbucket/*16.19*/.core.helper.html.preview(
          repository         = repository,
          content            = "",
          enableWikiLink     = false,
          enableRefsLink     = true,
          enableLineBreaks   = true,
          enableTaskList     = true,
          hasWritePermission = hasWritePermission,
          completionContext  = "issues",
          style              = "height: 100px; max-height: 150px;",
          elastic            = true,
          focus              = focus,
          uid                = uid
        )),format.raw/*29.10*/("""
        """),_display_(if(fileName.isDefined)/*30.32*/{_display_(Seq[Any](format.raw/*30.33*/("""
          """),format.raw/*31.11*/("""<div class="pull-right">
            <input type="button" class="btn btn-default" value="Cancel"/>
            <input type="submit" id="btn-inline-comment-"""),_display_(/*33.58*/uid),format.raw/*33.61*/("""" class="btn btn-success" formaction=""""),_display_(/*33.100*/helpers/*33.107*/.url(repository)),format.raw/*33.123*/("""/commit/"""),_display_(/*33.132*/commitId),format.raw/*33.140*/("""/comment/new" value="Comment"/>
          </div>
        """)))} else {null} ),format.raw/*35.10*/("""
      """),format.raw/*36.7*/("""</div>
    </div>
    """),_display_(if(!fileName.isDefined)/*38.29*/{_display_(Seq[Any](format.raw/*38.30*/("""
      """),format.raw/*39.7*/("""<div class="pull-right">
        <input type="submit" class="btn btn-success" formaction=""""),_display_(/*40.67*/helpers/*40.74*/.url(repository)),format.raw/*40.90*/("""/commit/"""),_display_(/*40.99*/commitId),format.raw/*40.107*/("""/comment/new" value="Comment on this commit"/>
      </div>
    """)))} else {null} ),format.raw/*42.6*/("""
    """),_display_(/*43.6*/issueId/*43.13*/.map/*43.17*/ { issueId =>_display_(Seq[Any](format.raw/*43.30*/(""" """),format.raw/*43.31*/("""<input type="hidden" name="issueId" value=""""),_display_(/*43.75*/issueId),format.raw/*43.82*/(""""> """)))}),format.raw/*43.86*/("""
    """),_display_(/*44.6*/fileName/*44.14*/.map/*44.18*/ { fileName =>_display_(Seq[Any](format.raw/*44.32*/(""" """),format.raw/*44.33*/("""<input type="hidden" name="fileName" value=""""),_display_(/*44.78*/fileName),format.raw/*44.86*/(""""> """)))}),format.raw/*44.90*/("""
    """),_display_(/*45.6*/oldLineNumber/*45.19*/.map/*45.23*/ { oldLineNumber =>_display_(Seq[Any](format.raw/*45.42*/(""" """),format.raw/*45.43*/("""<input type="hidden" name="oldLineNumber" value=""""),_display_(/*45.93*/oldLineNumber),format.raw/*45.106*/(""""> """)))}),format.raw/*45.110*/("""
    """),_display_(/*46.6*/newLineNumber/*46.19*/.map/*46.23*/ { newLineNumber =>_display_(Seq[Any](format.raw/*46.42*/(""" """),format.raw/*46.43*/("""<input type="hidden" name="newLineNumber" value=""""),_display_(/*46.93*/newLineNumber),format.raw/*46.106*/(""""> """)))}),format.raw/*46.110*/("""
  """),format.raw/*47.3*/("""</form>
  <script>
    $('#btn-inline-comment-"""),_display_(/*49.29*/uid),format.raw/*49.32*/("""').click(function(e) """),format.raw/*49.53*/("""{"""),format.raw/*49.54*/("""
      """),format.raw/*50.7*/("""e.preventDefault();
      var $form = $(e.target).attr('disabled', 'disabled').closest('form');
      var param = """),format.raw/*52.19*/("""{"""),format.raw/*52.20*/("""}"""),format.raw/*52.21*/(""";
      $($form.serializeArray()).each(function(i, v) """),format.raw/*53.53*/("""{"""),format.raw/*53.54*/("""
        """),format.raw/*54.9*/("""param[v.name] = v.value;
      """),format.raw/*55.7*/("""}"""),format.raw/*55.8*/(""");

      """),_display_(if(newLineNumber.isDefined)/*57.35*/{_display_(Seq[Any](format.raw/*57.36*/("""
        """),format.raw/*58.9*/("""var diff = getDiffData($('table[filename=""""),_display_(/*58.52*/fileName),format.raw/*58.60*/(""""] table.diff tr:has(th.line-num.newline[line-number=""""),_display_(/*58.115*/newLineNumber),format.raw/*58.128*/(""""])'));
        param['diff'] = JSON.stringify(diff);
      """)))}else if(oldLineNumber.isDefined)/*60.41*/{_display_(Seq[Any](format.raw/*60.42*/("""
        """),format.raw/*61.9*/("""var diff = getDiffData($('table[filename=""""),_display_(/*61.52*/fileName),format.raw/*61.60*/(""""] table.diff tr:has(th.line-num.oldline[line-number=""""),_display_(/*61.115*/oldLineNumber),format.raw/*61.128*/(""""])'));
        param['diff'] = JSON.stringify(diff);
      """)))} else {null} ),format.raw/*63.8*/("""

      """),format.raw/*65.7*/("""$.ajax("""),format.raw/*65.14*/("""{"""),format.raw/*65.15*/("""
        """),format.raw/*66.9*/("""url: '"""),_display_(/*66.16*/helpers/*66.23*/.url(repository)),format.raw/*66.39*/("""/commit/"""),_display_(/*66.48*/commitId),format.raw/*66.56*/("""/comment/_data/new',
        type: 'POST',
        data: param
      """),format.raw/*69.7*/("""}"""),format.raw/*69.8*/(""").done(function(data) """),format.raw/*69.30*/("""{"""),format.raw/*69.31*/("""
        """),format.raw/*70.9*/("""var tmp;
        if (window.viewType == 0) """),format.raw/*71.35*/("""{"""),format.raw/*71.36*/("""
          """),format.raw/*72.11*/("""tmp = '"""),_display_(/*72.19*/(oldLineNumber, newLineNumber)/*72.49*/ match/*72.55*/ {/*73.13*/case (Some(_), None) =>/*73.36*/ {_display_(Seq[Any](format.raw/*73.38*/("""<td colspan="2" class="comment-box-container"></td><td colspan="2"></td>""")))}/*74.13*/case (None, Some(_)) =>/*74.36*/ {_display_(Seq[Any](format.raw/*74.38*/("""<td colspan="2"></td><td colspan="2" class="comment-box-container"></td>""")))}/*75.13*/case _ =>/*75.22*/ {_display_(Seq[Any](format.raw/*75.24*/("""<td colspan="3" class="comment-box-container"></td>""")))}}),format.raw/*76.12*/("""'
        """),format.raw/*77.9*/("""}"""),format.raw/*77.10*/(""" """),format.raw/*77.11*/("""else """),format.raw/*77.16*/("""{"""),format.raw/*77.17*/("""
          """),format.raw/*78.11*/("""tmp = '<td colspan="3" class="comment-box-container"></td>'
        """),format.raw/*79.9*/("""}"""),format.raw/*79.10*/("""
        """),format.raw/*80.9*/("""var $tr = $form.closest('tr.not-diff');

        // Apply comment
        var $addedCommentContent = $tr.removeClass('inline-comment-form').html(tmp).find('.comment-box-container');
        $addedCommentContent.html(data);
        $addedCommentContent.find('div[class*=commit-commentContent-]').on('click', ':checkbox', function(ev)"""),format.raw/*85.110*/("""{"""),format.raw/*85.111*/("""
          """),format.raw/*86.11*/("""var $commentContent = $(ev.target).parents('div[class*=commit-commentContent-]'),
            commentId = $commentContent.attr('class').match(/commit-commentContent-.+/)[0].replace(/commit-commentContent-/, ''),
            checkboxes = $commentContent.find(':checkbox');
          $.get('"""),_display_(/*89.19*/helpers/*89.26*/.url(repository)),format.raw/*89.42*/("""/commit_comments/_data/' + commentId, """),format.raw/*89.80*/("""{"""),format.raw/*89.81*/(""" """),format.raw/*89.82*/("""dataType : 'html' """),format.raw/*89.100*/("""}"""),format.raw/*89.101*/(""",
            function(responseContent)"""),format.raw/*90.38*/("""{"""),format.raw/*90.39*/("""
              """),format.raw/*91.15*/("""$.ajax("""),format.raw/*91.22*/("""{"""),format.raw/*91.23*/("""
                """),format.raw/*92.17*/("""url: '"""),_display_(/*92.24*/helpers/*92.31*/.url(repository)),format.raw/*92.47*/("""/commit_comments/edit/' + commentId,
                type: 'POST',
                data: """),format.raw/*94.23*/("""{"""),format.raw/*94.24*/("""
                  """),format.raw/*95.19*/("""issueId : 0,
                  content : applyTaskListCheckedStatus(responseContent, checkboxes)
                """),format.raw/*97.17*/("""}"""),format.raw/*97.18*/(""",
                success: function(data) """),format.raw/*98.41*/("""{"""),format.raw/*98.42*/("""
                  """),format.raw/*99.19*/("""$('.commit-commentContent-' + commentId).html(data.content);
                """),format.raw/*100.17*/("""}"""),format.raw/*100.18*/("""
              """),format.raw/*101.15*/("""}"""),format.raw/*101.16*/(""");
            """),format.raw/*102.13*/("""}"""),format.raw/*102.14*/("""
          """),format.raw/*103.11*/(""");
        """),format.raw/*104.9*/("""}"""),format.raw/*104.10*/(""");

        // Show reply comment form
        var replyComment = $tr.prev().find('.reply-comment').closest('.not-diff').show();
        if(replyComment.length != 0)"""),format.raw/*108.37*/("""{"""),format.raw/*108.38*/("""
          """),format.raw/*109.11*/("""replyComment.remove();
          $tr.after(replyComment);
        """),format.raw/*111.9*/("""}"""),format.raw/*111.10*/(""" """),format.raw/*111.11*/("""else """),format.raw/*111.16*/("""{"""),format.raw/*111.17*/("""
          """),format.raw/*112.11*/("""var $v = $('<div class="commit-comment-box reply-comment-box">')
            .append($('<input type="text" class="form-control reply-comment" placeholder="Reply...">')
              .attr('data-filename', '"""),_display_(/*114.40*/fileName),format.raw/*114.48*/("""')
              .attr('data-newline',  """),_display_(/*115.39*/newLineNumber/*115.52*/.getOrElse("undefined")),format.raw/*115.75*/(""")
              .attr('data-oldline',  """),_display_(/*116.39*/oldLineNumber/*116.52*/.getOrElse("undefined")),format.raw/*116.75*/("""));

          """),_display_(if(oldLineNumber.isDefined)/*118.39*/{_display_(Seq[Any](format.raw/*118.40*/("""
            """),_display_(if(newLineNumber.isDefined)/*119.41*/{_display_(Seq[Any](format.raw/*119.42*/("""
              """),format.raw/*120.15*/("""var tmp = getInlineContainer();
            """)))}else/*121.20*/{_display_(Seq[Any](format.raw/*121.21*/("""
              """),format.raw/*122.15*/("""var tmp = getInlineContainer('old');
            """)))}),format.raw/*123.14*/("""
            """),format.raw/*124.13*/("""tmp.children('td:first').html($v);
          """)))}else/*125.18*/{_display_(Seq[Any](format.raw/*125.19*/("""
            """),format.raw/*126.13*/("""var tmp = getInlineContainer('new');
            tmp.children('td:last').html($v);
          """)))}),format.raw/*128.12*/("""
          """),format.raw/*129.11*/("""$tr.after(tmp);
        """),format.raw/*130.9*/("""}"""),format.raw/*130.10*/("""

        """),format.raw/*132.9*/("""// $('#comment-list').append(data);
        // if (typeof $('#show-notes')[0] !== 'undefined' && !$('#show-notes')[0].checked) """),format.raw/*133.92*/("""{"""),format.raw/*133.93*/("""
        """),format.raw/*134.9*/("""//   $('#comment-list').children('.inline-comment').hide();
        // """),format.raw/*135.12*/("""}"""),format.raw/*135.13*/("""
      """),format.raw/*136.7*/("""}"""),format.raw/*136.8*/(""").fail(function(req) """),format.raw/*136.29*/("""{"""),format.raw/*136.30*/("""
        """),format.raw/*137.9*/("""$(e.target).removeAttr('disabled');
        $('#error-content', $form).html($.parseJSON(req.responseText).content);
      """),format.raw/*139.7*/("""}"""),format.raw/*139.8*/(""");
    """),format.raw/*140.5*/("""}"""),format.raw/*140.6*/(""");

    function getInlineContainer() """),format.raw/*142.35*/("""{"""),format.raw/*142.36*/("""
      """),format.raw/*143.7*/("""if (window.viewType == 0) """),format.raw/*143.33*/("""{"""),format.raw/*143.34*/("""
        """),format.raw/*144.9*/("""if("""),_display_(/*144.13*/newLineNumber/*144.26*/.isDefined),format.raw/*144.36*/(""")"""),format.raw/*144.37*/("""{"""),format.raw/*144.38*/("""
          """),format.raw/*145.11*/("""return $('<tr class="not-diff"><td colspan="2"></td><td colspan="2" class="comment-box-container"></td></tr>');
        """),format.raw/*146.9*/("""}"""),format.raw/*146.10*/("""
        """),format.raw/*147.9*/("""if("""),_display_(/*147.13*/oldLineNumber/*147.26*/.isDefined),format.raw/*147.36*/(""")"""),format.raw/*147.37*/("""{"""),format.raw/*147.38*/("""
          """),format.raw/*148.11*/("""return $('<tr class="not-diff"><td colspan="2" class="comment-box-container"></td><td colspan="2"></td></tr>');
        """),format.raw/*149.9*/("""}"""),format.raw/*149.10*/("""
      """),format.raw/*150.7*/("""}"""),format.raw/*150.8*/("""
      """),format.raw/*151.7*/("""return $('<tr class="not-diff"><td colspan="3" class="comment-box-container"></td></tr>');
    """),format.raw/*152.5*/("""}"""),format.raw/*152.6*/("""

    """),format.raw/*154.5*/("""function getDiffData(tr)"""),format.raw/*154.29*/("""{"""),format.raw/*154.30*/("""
      """),format.raw/*155.7*/("""if(window.viewType === 0) """),format.raw/*155.33*/("""{"""),format.raw/*155.34*/("""
        """),format.raw/*156.9*/("""return getDiffDataOnSplitMode(tr);
      """),format.raw/*157.7*/("""}"""),format.raw/*157.8*/(""" """),format.raw/*157.9*/("""else """),format.raw/*157.14*/("""{"""),format.raw/*157.15*/("""
        """),format.raw/*158.9*/("""return getDiffDataOnUnifiedMode(tr);
      """),format.raw/*159.7*/("""}"""),format.raw/*159.8*/("""
    """),format.raw/*160.5*/("""}"""),format.raw/*160.6*/("""

    """),format.raw/*162.5*/("""function getDiffDataOnUnifiedMode(tr) """),format.raw/*162.43*/("""{"""),format.raw/*162.44*/("""
      """),format.raw/*163.7*/("""var result = [];
      var count = 0;

      while(tr && count < 4)"""),format.raw/*166.29*/("""{"""),format.raw/*166.30*/("""
        """),format.raw/*167.9*/("""var oldTh = tr.find('th.oldline');
        var newTh = tr.find('th.newline');

        var oldLineNumber = oldTh.attr('line-number');
        var newLineNumber = newTh.attr('line-number');

        if(!oldLineNumber && !newLineNumber)"""),format.raw/*173.45*/("""{"""),format.raw/*173.46*/("""
          """),format.raw/*174.11*/("""break;
        """),format.raw/*175.9*/("""}"""),format.raw/*175.10*/("""

        """),format.raw/*177.9*/("""result.unshift("""),format.raw/*177.24*/("""{"""),format.raw/*177.25*/("""
          """),format.raw/*178.11*/("""'oldLine': oldLineNumber,
          'newLine': newLineNumber,
          'type': tr.has('td.insert').length > 0 ? 'insert' : tr.has('td.delete').length > 0 ? 'delete' : 'equal',
          'text': tr.find('td span').text()
        """),format.raw/*182.9*/("""}"""),format.raw/*182.10*/(""");

        tr = tr.prev('tr:has(th.line-num)');
        count++;
      """),format.raw/*186.7*/("""}"""),format.raw/*186.8*/("""

      """),format.raw/*188.7*/("""return result;
    """),format.raw/*189.5*/("""}"""),format.raw/*189.6*/("""

    """),format.raw/*191.5*/("""function getDiffDataOnSplitMode(tr) """),format.raw/*191.41*/("""{"""),format.raw/*191.42*/("""
      """),format.raw/*192.7*/("""var result = [];
      var count = 0;

      while(tr && count < 4)"""),format.raw/*195.29*/("""{"""),format.raw/*195.30*/("""
        """),format.raw/*196.9*/("""var oldTh = tr.find('th.oldline');
        var newTh = tr.find('th.newline');

        var oldLineNumber = oldTh.attr('line-number');
        var newLineNumber = newTh.attr('line-number');

        if(!oldLineNumber && !newLineNumber)"""),format.raw/*202.45*/("""{"""),format.raw/*202.46*/("""
          """),format.raw/*203.11*/("""break;
        """),format.raw/*204.9*/("""}"""),format.raw/*204.10*/("""

        """),format.raw/*206.9*/("""var oldTd = oldTh.next();
        var newTd = newTh.next();

        if (oldTd.hasClass('equal') && newTd.hasClass('equal')) """),format.raw/*209.65*/("""{"""),format.raw/*209.66*/("""
          """),format.raw/*210.11*/("""result.unshift("""),format.raw/*210.26*/("""{"""),format.raw/*210.27*/("""
            """),format.raw/*211.13*/("""'oldLine': oldLineNumber,
            'newLine': newLineNumber,
            'type': 'equal',
            'text': newTd.find('span').text()
          """),format.raw/*215.11*/("""}"""),format.raw/*215.12*/(""");
          count++;
        """),format.raw/*217.9*/("""}"""),format.raw/*217.10*/(""" """),format.raw/*217.11*/("""else """),format.raw/*217.16*/("""{"""),format.raw/*217.17*/("""
          """),format.raw/*218.11*/("""if(newLineNumber) """),format.raw/*218.29*/("""{"""),format.raw/*218.30*/("""
            """),format.raw/*219.13*/("""result.unshift("""),format.raw/*219.28*/("""{"""),format.raw/*219.29*/("""
              """),format.raw/*220.15*/("""'newLine': newLineNumber,
              'type': 'insert',
              'text': newTd.find('span').text()
            """),format.raw/*223.13*/("""}"""),format.raw/*223.14*/(""");
            count++;
          """),format.raw/*225.11*/("""}"""),format.raw/*225.12*/("""
          """),format.raw/*226.11*/("""if(oldLineNumber) """),format.raw/*226.29*/("""{"""),format.raw/*226.30*/("""
            """),format.raw/*227.13*/("""result.unshift("""),format.raw/*227.28*/("""{"""),format.raw/*227.29*/("""
              """),format.raw/*228.15*/("""'oldLine': oldLineNumber,
              'type': 'delete',
              'text': oldTd.find('span').text()
            """),format.raw/*231.13*/("""}"""),format.raw/*231.14*/(""");
            count++;
          """),format.raw/*233.11*/("""}"""),format.raw/*233.12*/("""
        """),format.raw/*234.9*/("""}"""),format.raw/*234.10*/("""
        """),format.raw/*235.9*/("""tr = tr.prev('tr:has(th.line-num)');
      """),format.raw/*236.7*/("""}"""),format.raw/*236.8*/("""

      """),format.raw/*238.7*/("""return result;
    """),format.raw/*239.5*/("""}"""),format.raw/*239.6*/("""
  """),format.raw/*240.3*/("""</script>
""")))} else {null} ),format.raw/*241.2*/("""
"""))
      }
    }
  }

  def render(commitId:String,fileName:Option[String],oldLineNumber:Option[Int],newLineNumber:Option[Int],issueId:Option[Int],hasWritePermission:Boolean,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,focus:Boolean,uid:Long,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(commitId,fileName,oldLineNumber,newLineNumber,issueId,hasWritePermission,repository,focus,uid)(context)

  def f:((String,Option[String],Option[Int],Option[Int],Option[Int],Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean,Long) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (commitId,fileName,oldLineNumber,newLineNumber,issueId,hasWritePermission,repository,focus,uid) => (context) => apply(commitId,fileName,oldLineNumber,newLineNumber,issueId,hasWritePermission,repository,focus,uid)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/repo/commentform.scala.html
                  HASH: 8a8a07127bcfcab54ccaaf9392856189e239778f
                  MATRIX: 749->1|1208->388|1307->458|1346->459|1400->486|1439->487|1494->498|1524->501|1684->634|1702->643|2256->1176|2315->1208|2354->1209|2393->1220|2576->1376|2600->1379|2667->1418|2684->1425|2722->1441|2759->1450|2789->1458|2891->1516|2925->1523|2998->1569|3037->1570|3071->1577|3189->1668|3205->1675|3242->1691|3278->1700|3308->1708|3416->1773|3448->1779|3464->1786|3477->1790|3528->1803|3557->1804|3628->1848|3656->1855|3691->1859|3723->1865|3740->1873|3753->1877|3805->1891|3834->1892|3906->1937|3935->1945|3970->1949|4002->1955|4024->1968|4037->1972|4094->1991|4123->1992|4200->2042|4235->2055|4271->2059|4303->2065|4325->2078|4338->2082|4395->2101|4424->2102|4501->2152|4536->2165|4572->2169|4602->2172|4676->2219|4700->2222|4749->2243|4778->2244|4812->2251|4954->2365|4983->2366|5012->2367|5094->2421|5123->2422|5159->2431|5217->2462|5245->2463|5310->2501|5349->2502|5385->2511|5455->2554|5484->2562|5567->2617|5602->2630|5714->2724|5753->2725|5789->2734|5859->2777|5888->2785|5971->2840|6006->2853|6110->2914|6145->2922|6180->2929|6209->2930|6245->2939|6279->2946|6295->2953|6332->2969|6368->2978|6397->2986|6493->3055|6521->3056|6571->3078|6600->3079|6636->3088|6707->3131|6736->3132|6775->3143|6810->3151|6849->3181|6864->3187|6875->3202|6907->3225|6947->3227|7039->3313|7071->3336|7111->3338|7203->3424|7221->3433|7261->3435|7345->3499|7382->3509|7411->3510|7440->3511|7473->3516|7502->3517|7541->3528|7636->3596|7665->3597|7701->3606|8062->3938|8092->3939|8131->3950|8448->4240|8464->4247|8501->4263|8567->4301|8596->4302|8625->4303|8672->4321|8702->4322|8769->4361|8798->4362|8841->4377|8876->4384|8905->4385|8950->4402|8984->4409|9000->4416|9037->4432|9154->4521|9183->4522|9230->4541|9371->4654|9400->4655|9470->4697|9499->4698|9546->4717|9652->4794|9682->4795|9726->4810|9756->4811|9800->4826|9830->4827|9870->4838|9909->4849|9939->4850|10133->5015|10163->5016|10203->5027|10297->5093|10327->5094|10357->5095|10391->5100|10421->5101|10461->5112|10696->5319|10726->5327|10795->5368|10818->5381|10863->5404|10931->5444|10954->5457|10999->5480|11070->5523|11110->5524|11179->5565|11219->5566|11263->5581|11332->5632|11372->5633|11416->5648|11498->5698|11540->5711|11610->5763|11650->5764|11692->5777|11818->5871|11858->5882|11910->5906|11940->5907|11978->5917|12134->6044|12164->6045|12201->6054|12301->6125|12331->6126|12366->6133|12395->6134|12445->6155|12475->6156|12512->6165|12662->6287|12691->6288|12726->6295|12755->6296|12822->6334|12852->6335|12887->6342|12942->6368|12972->6369|13009->6378|13041->6382|13064->6395|13096->6405|13126->6406|13156->6407|13196->6418|13344->6538|13374->6539|13411->6548|13443->6552|13466->6565|13498->6575|13528->6576|13558->6577|13598->6588|13746->6708|13776->6709|13811->6716|13840->6717|13875->6724|13998->6819|14027->6820|14061->6826|14114->6850|14144->6851|14179->6858|14234->6884|14264->6885|14301->6894|14370->6935|14399->6936|14428->6937|14462->6942|14492->6943|14529->6952|14600->6995|14629->6996|14662->7001|14691->7002|14725->7008|14792->7046|14822->7047|14857->7054|14953->7121|14983->7122|15020->7131|15283->7365|15313->7366|15353->7377|15396->7392|15426->7393|15464->7403|15508->7418|15538->7419|15578->7430|15835->7659|15865->7660|15965->7732|15994->7733|16030->7741|16077->7760|16106->7761|16140->7767|16205->7803|16235->7804|16270->7811|16366->7878|16396->7879|16433->7888|16696->8122|16726->8123|16766->8134|16809->8149|16839->8150|16877->8160|17031->8285|17061->8286|17101->8297|17145->8312|17175->8313|17217->8326|17395->8475|17425->8476|17483->8506|17513->8507|17543->8508|17577->8513|17607->8514|17647->8525|17694->8543|17724->8544|17766->8557|17810->8572|17840->8573|17884->8588|18031->8706|18061->8707|18124->8741|18154->8742|18194->8753|18241->8771|18271->8772|18313->8785|18357->8800|18387->8801|18431->8816|18578->8934|18608->8935|18671->8969|18701->8970|18738->8979|18768->8980|18805->8989|18876->9032|18905->9033|18941->9041|18988->9060|19017->9061|19048->9064|19103->9075
                  LINES: 14->1|25->10|28->11|28->11|29->12|29->12|29->12|30->13|33->16|33->16|46->29|47->30|47->30|48->31|50->33|50->33|50->33|50->33|50->33|50->33|50->33|52->35|53->36|55->38|55->38|56->39|57->40|57->40|57->40|57->40|57->40|59->42|60->43|60->43|60->43|60->43|60->43|60->43|60->43|60->43|61->44|61->44|61->44|61->44|61->44|61->44|61->44|61->44|62->45|62->45|62->45|62->45|62->45|62->45|62->45|62->45|63->46|63->46|63->46|63->46|63->46|63->46|63->46|63->46|64->47|66->49|66->49|66->49|66->49|67->50|69->52|69->52|69->52|70->53|70->53|71->54|72->55|72->55|74->57|74->57|75->58|75->58|75->58|75->58|75->58|77->60|77->60|78->61|78->61|78->61|78->61|78->61|80->63|82->65|82->65|82->65|83->66|83->66|83->66|83->66|83->66|83->66|86->69|86->69|86->69|86->69|87->70|88->71|88->71|89->72|89->72|89->72|89->72|89->73|89->73|89->73|89->74|89->74|89->74|89->75|89->75|89->75|89->76|90->77|90->77|90->77|90->77|90->77|91->78|92->79|92->79|93->80|98->85|98->85|99->86|102->89|102->89|102->89|102->89|102->89|102->89|102->89|102->89|103->90|103->90|104->91|104->91|104->91|105->92|105->92|105->92|105->92|107->94|107->94|108->95|110->97|110->97|111->98|111->98|112->99|113->100|113->100|114->101|114->101|115->102|115->102|116->103|117->104|117->104|121->108|121->108|122->109|124->111|124->111|124->111|124->111|124->111|125->112|127->114|127->114|128->115|128->115|128->115|129->116|129->116|129->116|131->118|131->118|132->119|132->119|133->120|134->121|134->121|135->122|136->123|137->124|138->125|138->125|139->126|141->128|142->129|143->130|143->130|145->132|146->133|146->133|147->134|148->135|148->135|149->136|149->136|149->136|149->136|150->137|152->139|152->139|153->140|153->140|155->142|155->142|156->143|156->143|156->143|157->144|157->144|157->144|157->144|157->144|157->144|158->145|159->146|159->146|160->147|160->147|160->147|160->147|160->147|160->147|161->148|162->149|162->149|163->150|163->150|164->151|165->152|165->152|167->154|167->154|167->154|168->155|168->155|168->155|169->156|170->157|170->157|170->157|170->157|170->157|171->158|172->159|172->159|173->160|173->160|175->162|175->162|175->162|176->163|179->166|179->166|180->167|186->173|186->173|187->174|188->175|188->175|190->177|190->177|190->177|191->178|195->182|195->182|199->186|199->186|201->188|202->189|202->189|204->191|204->191|204->191|205->192|208->195|208->195|209->196|215->202|215->202|216->203|217->204|217->204|219->206|222->209|222->209|223->210|223->210|223->210|224->211|228->215|228->215|230->217|230->217|230->217|230->217|230->217|231->218|231->218|231->218|232->219|232->219|232->219|233->220|236->223|236->223|238->225|238->225|239->226|239->226|239->226|240->227|240->227|240->227|241->228|244->231|244->231|246->233|246->233|247->234|247->234|248->235|249->236|249->236|251->238|252->239|252->239|253->240|254->241
                  -- GENERATED --
              */
          