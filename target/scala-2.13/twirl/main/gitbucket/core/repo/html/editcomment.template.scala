
package gitbucket.core.repo.html

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


Seq[Any](format.raw/*3.1*/("""<span class="error-edit-content-"""),_display_(/*3.34*/commentId),format.raw/*3.43*/(""" """),format.raw/*3.44*/("""error"></span>
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
"""),format.raw/*18.1*/("""<div class="text-right">
  <input type="button" class="cancel-comment-"""),_display_(/*19.47*/commentId),format.raw/*19.56*/(""" """),format.raw/*19.57*/("""btn btn-small btn-default" value="Cancel"/>
  <input type="button" class="update-comment-"""),_display_(/*20.47*/commentId),format.raw/*20.56*/(""" """),format.raw/*20.57*/("""btn btn-small btn-success" value="Update comment"/>
</div>
<script>
$(function()"""),format.raw/*23.13*/("""{"""),format.raw/*23.14*/("""
  """),format.raw/*24.3*/("""var curriedCallback = function($box) """),format.raw/*24.40*/("""{"""),format.raw/*24.41*/("""
    """),format.raw/*25.5*/("""return function(data)"""),format.raw/*25.26*/("""{"""),format.raw/*25.27*/("""
      """),format.raw/*26.7*/("""$('.update-comment-"""),_display_(/*26.27*/commentId),format.raw/*26.36*/(""", .cancel-comment-"""),_display_(/*26.55*/commentId),format.raw/*26.64*/("""', $box).removeAttr('disabled');
      $('.commit-commentContent-"""),_display_(/*27.34*/commentId),format.raw/*27.43*/("""').empty().html(data.content);
      prettyPrint();
    """),format.raw/*29.5*/("""}"""),format.raw/*29.6*/("""
  """),format.raw/*30.3*/("""}"""),format.raw/*30.4*/("""

  """),format.raw/*32.3*/("""$(document).on('click', '.update-comment-"""),_display_(/*32.45*/commentId),format.raw/*32.54*/("""', function()"""),format.raw/*32.67*/("""{"""),format.raw/*32.68*/("""
    """),format.raw/*33.5*/("""var content = $(this).parent().parent().find('textarea[name=content]').val();
    $box = $(this).closest('.commit-comment-box');
    $('.update-comment-"""),_display_(/*35.25*/commentId),format.raw/*35.34*/(""", .cancel-comment-"""),_display_(/*35.53*/commentId),format.raw/*35.62*/("""', $box).attr('disabled', 'disabled');
    $.ajax("""),format.raw/*36.12*/("""{"""),format.raw/*36.13*/("""
      """),format.raw/*37.7*/("""url: '"""),_display_(/*37.14*/context/*37.21*/.path),format.raw/*37.26*/("""/"""),_display_(/*37.28*/repository/*37.38*/.owner),format.raw/*37.44*/("""/"""),_display_(/*37.46*/repository/*37.56*/.name),format.raw/*37.61*/("""/commit_comments/edit/"""),_display_(/*37.84*/commentId),format.raw/*37.93*/("""',
      type: 'POST',
      data: """),format.raw/*39.13*/("""{"""),format.raw/*39.14*/("""
        """),format.raw/*40.9*/("""content : content
      """),format.raw/*41.7*/("""}"""),format.raw/*41.8*/("""
    """),format.raw/*42.5*/("""}"""),format.raw/*42.6*/(""").done(
      curriedCallback($box)
    ).fail(function(req) """),format.raw/*44.26*/("""{"""),format.raw/*44.27*/("""
      """),format.raw/*45.7*/("""$('.update-comment-"""),_display_(/*45.27*/commentId),format.raw/*45.36*/(""", .cancel-comment-"""),_display_(/*45.55*/commentId),format.raw/*45.64*/("""', $box).removeAttr('disabled');
      $('.error-edit-content-"""),_display_(/*46.31*/commentId),format.raw/*46.40*/("""', $box).text($.parseJSON(req.responseText).content);
    """),format.raw/*47.5*/("""}"""),format.raw/*47.6*/(""");
  """),format.raw/*48.3*/("""}"""),format.raw/*48.4*/(""");

  $(document).on('click', '.cancel-comment-"""),_display_(/*50.45*/commentId),format.raw/*50.54*/("""', function()"""),format.raw/*50.67*/("""{"""),format.raw/*50.68*/("""
    """),format.raw/*51.5*/("""$box = $(this).closest('.box');
    $('.update-comment-"""),_display_(/*52.25*/commentId),format.raw/*52.34*/(""", .cancel-comment-"""),_display_(/*52.53*/commentId),format.raw/*52.62*/("""', $box).attr('disabled', 'disabled');
    $.get('"""),_display_(/*53.13*/context/*53.20*/.path),format.raw/*53.25*/("""/"""),_display_(/*53.27*/repository/*53.37*/.owner),format.raw/*53.43*/("""/"""),_display_(/*53.45*/repository/*53.55*/.name),format.raw/*53.60*/("""/commit_comments/_data/"""),_display_(/*53.84*/commentId),format.raw/*53.93*/("""', curriedCallback($box));
    return false;
  """),format.raw/*55.3*/("""}"""),format.raw/*55.4*/(""");
"""),format.raw/*56.1*/("""}"""),format.raw/*56.2*/(""");
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
                  SOURCE: src/main/twirl/gitbucket/core/repo/editcomment.scala.html
                  HASH: 658724c2360183a216642603df44d2976ae94d94
                  MATRIX: 680->1|931->159|990->192|1019->201|1047->202|1088->218|1105->227|1509->611|1537->612|1635->683|1665->692|1694->693|1811->783|1841->792|1870->793|1978->873|2007->874|2037->877|2102->914|2131->915|2163->920|2212->941|2241->942|2275->949|2322->969|2352->978|2398->997|2428->1006|2521->1072|2551->1081|2634->1137|2662->1138|2692->1141|2720->1142|2751->1146|2820->1188|2850->1197|2891->1210|2920->1211|2952->1216|3132->1369|3162->1378|3208->1397|3238->1406|3316->1456|3345->1457|3379->1464|3413->1471|3429->1478|3455->1483|3484->1485|3503->1495|3530->1501|3559->1503|3578->1513|3604->1518|3654->1541|3684->1550|3747->1585|3776->1586|3812->1595|3863->1619|3891->1620|3923->1625|3951->1626|4040->1687|4069->1688|4103->1695|4150->1715|4180->1724|4226->1743|4256->1752|4346->1815|4376->1824|4461->1882|4489->1883|4521->1888|4549->1889|4624->1937|4654->1946|4695->1959|4724->1960|4756->1965|4839->2021|4869->2030|4915->2049|4945->2058|5023->2109|5039->2116|5065->2121|5094->2123|5113->2133|5140->2139|5169->2141|5188->2151|5214->2156|5265->2180|5295->2189|5369->2236|5397->2237|5427->2240|5455->2241
                  LINES: 14->1|20->3|20->3|20->3|20->3|21->4|21->4|34->17|35->18|36->19|36->19|36->19|37->20|37->20|37->20|40->23|40->23|41->24|41->24|41->24|42->25|42->25|42->25|43->26|43->26|43->26|43->26|43->26|44->27|44->27|46->29|46->29|47->30|47->30|49->32|49->32|49->32|49->32|49->32|50->33|52->35|52->35|52->35|52->35|53->36|53->36|54->37|54->37|54->37|54->37|54->37|54->37|54->37|54->37|54->37|54->37|54->37|54->37|56->39|56->39|57->40|58->41|58->41|59->42|59->42|61->44|61->44|62->45|62->45|62->45|62->45|62->45|63->46|63->46|64->47|64->47|65->48|65->48|67->50|67->50|67->50|67->50|68->51|69->52|69->52|69->52|69->52|70->53|70->53|70->53|70->53|70->53|70->53|70->53|70->53|70->53|70->53|70->53|72->55|72->55|73->56|73->56
                  -- GENERATED --
              */
          