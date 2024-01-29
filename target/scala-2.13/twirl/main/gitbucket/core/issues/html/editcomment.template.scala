
package gitbucket.core.issues.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object editcomment extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[String,Int,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(content: String, commentId: Int,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""<span id="error-edit-content-"""),_display_(/*3.31*/commentId),format.raw/*3.40*/("""" class="error"></span>
"""),_display_(/*4.2*/gitbucket/*4.11*/.core.helper.html.preview(
  repository         = repository,
  content            = content,
  enableWikiLink     = false,
  enableRefsLink     = true,
  enableLineBreaks   = true,
  enableTaskList     = true,
  hasWritePermission = true,
  completionContext  = "issues",
  style              = "",
  elastic            = true,
  focus              = true,
  tabIndex           = 1
)),format.raw/*17.2*/("""
"""),format.raw/*18.1*/("""<div class="pull-right">
  <input type="button" id="cancel-comment-"""),_display_(/*19.44*/commentId),format.raw/*19.53*/("""" class="btn btn-default" value="Cancel"/>
  <input type="button" id="update-comment-"""),_display_(/*20.44*/commentId),format.raw/*20.53*/("""" class="btn btn-success" value="Update comment"/>
</div>
<script>
$(function()"""),format.raw/*23.13*/("""{"""),format.raw/*23.14*/("""
  """),format.raw/*24.3*/("""var callback = function(data)"""),format.raw/*24.32*/("""{"""),format.raw/*24.33*/("""
    """),format.raw/*25.5*/("""$('#update-comment-"""),_display_(/*25.25*/commentId),format.raw/*25.34*/(""", #cancel-comment-"""),_display_(/*25.53*/commentId),format.raw/*25.62*/("""').removeAttr('disabled');
    $('#commentContent-"""),_display_(/*26.25*/commentId),format.raw/*26.34*/("""').empty().html(data.content);
    prettyPrint();
  """),format.raw/*28.3*/("""}"""),format.raw/*28.4*/(""";

  $('#update-comment-"""),_display_(/*30.23*/commentId),format.raw/*30.32*/("""').click(function()"""),format.raw/*30.51*/("""{"""),format.raw/*30.52*/("""
    """),format.raw/*31.5*/("""var content = $(this).parent().parent().find('textarea[name=content]').val();
    $('#update-comment-"""),_display_(/*32.25*/commentId),format.raw/*32.34*/(""", #cancel-comment-"""),_display_(/*32.53*/commentId),format.raw/*32.62*/("""').attr('disabled', 'disabled');
    $.ajax("""),format.raw/*33.12*/("""{"""),format.raw/*33.13*/("""
      """),format.raw/*34.7*/("""url: '"""),_display_(/*34.14*/context/*34.21*/.path),format.raw/*34.26*/("""/"""),_display_(/*34.28*/repository/*34.38*/.owner),format.raw/*34.44*/("""/"""),_display_(/*34.46*/repository/*34.56*/.name),format.raw/*34.61*/("""/issue_comments/edit/"""),_display_(/*34.83*/commentId),format.raw/*34.92*/("""',
      type: 'POST',
      data: """),format.raw/*36.13*/("""{"""),format.raw/*36.14*/("""
        """),format.raw/*37.9*/("""issueId : 0,	// TODO
        content : content
      """),format.raw/*39.7*/("""}"""),format.raw/*39.8*/("""
    """),format.raw/*40.5*/("""}"""),format.raw/*40.6*/(""").done(
      callback
    ).fail(function(req) """),format.raw/*42.26*/("""{"""),format.raw/*42.27*/("""
      """),format.raw/*43.7*/("""$('#update-comment-"""),_display_(/*43.27*/commentId),format.raw/*43.36*/(""", #cancel-comment-"""),_display_(/*43.55*/commentId),format.raw/*43.64*/("""').removeAttr('disabled');
      $('#error-edit-content-"""),_display_(/*44.31*/commentId),format.raw/*44.40*/("""').text($.parseJSON(req.responseText).content);
    """),format.raw/*45.5*/("""}"""),format.raw/*45.6*/(""");
  """),format.raw/*46.3*/("""}"""),format.raw/*46.4*/(""");

  $('#cancel-comment-"""),_display_(/*48.23*/commentId),format.raw/*48.32*/("""').click(function()"""),format.raw/*48.51*/("""{"""),format.raw/*48.52*/("""
    """),format.raw/*49.5*/("""$('#update-comment-"""),_display_(/*49.25*/commentId),format.raw/*49.34*/(""", #cancel-comment-"""),_display_(/*49.53*/commentId),format.raw/*49.62*/("""').attr('disabled', 'disabled');
    $.get('"""),_display_(/*50.13*/context/*50.20*/.path),format.raw/*50.25*/("""/"""),_display_(/*50.27*/repository/*50.37*/.owner),format.raw/*50.43*/("""/"""),_display_(/*50.45*/repository/*50.55*/.name),format.raw/*50.60*/("""/issue_comments/_data/"""),_display_(/*50.83*/commentId),format.raw/*50.92*/("""', callback);
    return false;
  """),format.raw/*52.3*/("""}"""),format.raw/*52.4*/(""");
"""),format.raw/*53.1*/("""}"""),format.raw/*53.2*/(""");
</script>
"""))
      }
    }
  }

  def render(content:String,commentId:Int,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(content,commentId,repository)(context)

  def f:((String,Int,gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (content,commentId,repository) => (context) => apply(content,commentId,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/issues/editcomment.scala.html
                  HASH: 575f93fbf019dbcb312b197e0d523cef6cd8ef6b
                  MATRIX: 682->1|933->159|989->189|1018->198|1068->223|1085->232|1489->616|1517->617|1612->685|1642->694|1755->780|1785->789|1892->868|1921->869|1951->872|2008->901|2037->902|2069->907|2116->927|2146->936|2192->955|2222->964|2300->1015|2330->1024|2409->1076|2437->1077|2489->1102|2519->1111|2566->1130|2595->1131|2627->1136|2756->1238|2786->1247|2832->1266|2862->1275|2934->1319|2963->1320|2997->1327|3031->1334|3047->1341|3073->1346|3102->1348|3121->1358|3148->1364|3177->1366|3196->1376|3222->1381|3271->1403|3301->1412|3364->1447|3393->1448|3429->1457|3509->1510|3537->1511|3569->1516|3597->1517|3673->1565|3702->1566|3736->1573|3783->1593|3813->1602|3859->1621|3889->1630|3973->1687|4003->1696|4082->1748|4110->1749|4142->1754|4170->1755|4223->1781|4253->1790|4300->1809|4329->1810|4361->1815|4408->1835|4438->1844|4484->1863|4514->1872|4586->1917|4602->1924|4628->1929|4657->1931|4676->1941|4703->1947|4732->1949|4751->1959|4777->1964|4827->1987|4857->1996|4918->2030|4946->2031|4976->2034|5004->2035
                  LINES: 14->1|20->3|20->3|20->3|21->4|21->4|34->17|35->18|36->19|36->19|37->20|37->20|40->23|40->23|41->24|41->24|41->24|42->25|42->25|42->25|42->25|42->25|43->26|43->26|45->28|45->28|47->30|47->30|47->30|47->30|48->31|49->32|49->32|49->32|49->32|50->33|50->33|51->34|51->34|51->34|51->34|51->34|51->34|51->34|51->34|51->34|51->34|51->34|51->34|53->36|53->36|54->37|56->39|56->39|57->40|57->40|59->42|59->42|60->43|60->43|60->43|60->43|60->43|61->44|61->44|62->45|62->45|63->46|63->46|65->48|65->48|65->48|65->48|66->49|66->49|66->49|66->49|66->49|67->50|67->50|67->50|67->50|67->50|67->50|67->50|67->50|67->50|67->50|67->50|69->52|69->52|70->53|70->53
                  -- GENERATED --
              */
          