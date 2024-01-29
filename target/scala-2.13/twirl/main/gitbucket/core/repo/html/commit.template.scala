
package gitbucket.core.repo.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object commit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template13[String,gitbucket.core.util.JGitUtil.CommitInfo,List[String],List[String],Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])],List[gitbucket.core.model.Comment],gitbucket.core.service.RepositoryService.RepositoryInfo,Seq[gitbucket.core.util.JGitUtil.DiffInfo],Option[String],Boolean,Option[Any],Option[Any],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(commitId: String,
  commit: gitbucket.core.util.JGitUtil.CommitInfo,
  branches: List[String],
  tags: List[String],
  status: Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])],
  comments: List[gitbucket.core.model.Comment],
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  diffs: Seq[gitbucket.core.util.JGitUtil.DiffInfo],
  oldCommitId: Option[String],
  hasWritePermission: Boolean,
  info: Option[Any] = None,
  error: Option[Any] = None)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*13.2*/import gitbucket.core.view.helpers
/*14.2*/import gitbucket.core.view.helpers.RichHtmlSeq
/*15.2*/import gitbucket.core.model._


Seq[Any](_display_(/*16.2*/gitbucket/*16.11*/.core.html.main(commit.shortMessage, Some(repository))/*16.65*/{_display_(Seq[Any](format.raw/*16.66*/("""
  """),_display_(/*17.4*/gitbucket/*17.13*/.core.html.menu("files", repository, None, info, error)/*17.68*/{_display_(Seq[Any](format.raw/*17.69*/("""
    """),format.raw/*18.5*/("""<table class="table table-bordered">
      <tr>
        <th class="box-header">
          <div class="pull-right align-right btn-group">
            <a href=""""),_display_(/*22.23*/helpers/*22.30*/.url(repository)),format.raw/*22.46*/("""/tree/"""),_display_(/*22.53*/commit/*22.59*/.id),format.raw/*22.62*/("""" class="btn btn-default">Browse code</a>
            """),_display_(if(hasWritePermission)/*23.36*/ {_display_(Seq[Any](format.raw/*23.38*/("""
              """),format.raw/*24.15*/("""<a href=""""),_display_(/*24.25*/helpers/*24.32*/.url(repository)),format.raw/*24.48*/("""/tag/"""),_display_(/*24.54*/commit/*24.60*/.id),format.raw/*24.63*/("""" class="btn btn-default" rel="facebox">Add tag</a>
            """)))} else {null} ),format.raw/*25.14*/("""
          """),format.raw/*26.11*/("""</div>
          <div class="commit-log">"""),_display_(/*27.36*/helpers/*27.43*/.link(commit.summary, repository)),format.raw/*27.76*/("""</div>
          """),_display_(if(commit.description.isDefined)/*28.44*/{_display_(Seq[Any](format.raw/*28.45*/("""
            """),format.raw/*29.13*/("""<pre class="commit-description">"""),_display_(/*29.46*/helpers/*29.53*/.link(commit.description.get, repository)),format.raw/*29.94*/("""</pre>
          """)))} else {null} ),format.raw/*30.12*/("""
          """),format.raw/*31.11*/("""<div class="small" style="font-weight: normal;">
            """),_display_(if(branches.nonEmpty)/*32.35*/{_display_(Seq[Any](format.raw/*32.36*/("""
              """),format.raw/*33.15*/("""<span class="muted">
                <i class="octicon octicon-git-branch"></i>
                """),_display_(/*35.18*/branches/*35.26*/.zipWithIndex.map/*35.43*/ { case (branch, i) =>_display_(Seq[Any](format.raw/*35.65*/("""
                  """),format.raw/*36.19*/("""<a href=""""),_display_(/*36.29*/helpers/*36.36*/.url(repository)),format.raw/*36.52*/("""/tree/"""),_display_(/*36.59*/helpers/*36.66*/.encodeRefName(branch)),format.raw/*36.88*/("""" class="branch" id="branch-"""),_display_(/*36.117*/i),format.raw/*36.118*/("""">"""),_display_(/*36.121*/branch),format.raw/*36.127*/("""</a>
                """)))}),format.raw/*37.18*/("""
              """),format.raw/*38.15*/("""</span>
            """)))} else {null} ),format.raw/*39.14*/("""
            """),_display_(if(tags.nonEmpty)/*40.31*/{_display_(Seq[Any](format.raw/*40.32*/("""
              """),format.raw/*41.15*/("""<span class="muted">
                <i class="octicon octicon-tag"></i>
                """),_display_(/*43.18*/tags/*43.22*/.zipWithIndex.map/*43.39*/ { case (tag, i) =>_display_(Seq[Any](format.raw/*43.58*/("""
                  """),format.raw/*44.19*/("""<a href=""""),_display_(/*44.29*/helpers/*44.36*/.url(repository)),format.raw/*44.52*/("""/tree/"""),_display_(/*44.59*/tag),format.raw/*44.62*/("""" class="tag" id="tag-"""),_display_(/*44.85*/i),format.raw/*44.86*/("""">"""),_display_(/*44.89*/tag),format.raw/*44.92*/("""</a>
                """)))}),format.raw/*45.18*/("""
              """),format.raw/*46.15*/("""</span>
            """)))} else {null} ),format.raw/*47.14*/("""
          """),format.raw/*48.11*/("""</div>
        </th>
      </tr>
      <tr>
        <td>
          <div class="pull-right">
            <div>
              """),_display_(if(commit.parents.size == 0)/*55.44*/{_display_(Seq[Any](format.raw/*55.45*/("""
                """),format.raw/*56.17*/("""<span class="muted">0 parent</span>
              """)))} else {null} ),format.raw/*57.16*/("""
              """),_display_(if(commit.parents.size == 1)/*58.44*/{_display_(Seq[Any](format.raw/*58.45*/("""
                """),format.raw/*59.17*/("""<span class="muted">1 parent</span>
                <a href=""""),_display_(/*60.27*/helpers/*60.34*/.url(repository)),format.raw/*60.50*/("""/commit/"""),_display_(/*60.59*/commit/*60.65*/.parents(0)),format.raw/*60.76*/("""" class="commit-id monospace strong">"""),_display_(/*60.114*/commit/*60.120*/.parents(0).substring(0, 7)),format.raw/*60.147*/("""</a>
              """)))} else {null} ),format.raw/*61.16*/("""
              """),format.raw/*62.15*/("""<span class="muted ">commit</span> <span class="commit-id monospace strong">"""),_display_(/*62.92*/commit/*62.98*/.id),format.raw/*62.101*/("""</span>
            </div>
            """),_display_(if(commit.parents.size > 1)/*64.41*/{_display_(Seq[Any](format.raw/*64.42*/("""
              """),format.raw/*65.15*/("""<div>
                <span class="muted">"""),_display_(/*66.38*/commit/*66.44*/.parents.size),format.raw/*66.57*/(""" """),format.raw/*66.58*/("""parents
                """),_display_(/*67.18*/commit/*67.24*/.parents.map/*67.36*/ { parent =>_display_(Seq[Any](format.raw/*67.48*/("""
                  """),format.raw/*68.19*/("""<a href=""""),_display_(/*68.29*/helpers/*68.36*/.url(repository)),format.raw/*68.52*/("""/commit/"""),_display_(/*68.61*/parent),format.raw/*68.67*/("""" class="commit-id monospace strong">"""),_display_(/*68.105*/parent/*68.111*/.substring(0, 7)),format.raw/*68.127*/("""</a>
                """)))}/*69.18*/.mkHtml(" + ")),format.raw/*69.32*/("""
                """),format.raw/*70.17*/("""</span>
              </div>
            """)))} else {null} ),format.raw/*72.14*/("""
          """),format.raw/*73.11*/("""</div>

          <div class="author-info">
            <div class="author">
              """),_display_(/*77.16*/helpers/*77.23*/.avatarLink(commit, 20)),format.raw/*77.46*/("""
              """),format.raw/*78.15*/("""<span>"""),_display_(/*78.22*/helpers/*78.29*/.user(commit.authorName, commit.authorEmailAddress, "username strong")),format.raw/*78.99*/("""</span>
              <span class="muted">authored """),_display_(/*79.45*/gitbucket/*79.54*/.core.helper.html.datetimeago(commit.authorTime)),format.raw/*79.102*/("""</span>
              """),_display_(/*80.16*/status/*80.22*/.map/*80.26*/ { case (summary, statuses) =>_display_(Seq[Any](format.raw/*80.56*/("""
                """),_display_(/*81.18*/gitbucket/*81.27*/.core.helper.html.commitstatus(commit.id, summary, statuses)),format.raw/*81.87*/("""
              """)))}),format.raw/*82.16*/("""
            """),format.raw/*83.13*/("""</div>
            """),_display_(if(commit.isDifferentFromAuthor)/*84.46*/ {_display_(Seq[Any](format.raw/*84.48*/("""
              """),format.raw/*85.15*/("""<div class="committer">
                <span class="octicon octicon-arrow-right"></span>
                <span>"""),_display_(/*87.24*/helpers/*87.31*/.user(commit.committerName, commit.committerEmailAddress, "username strong")),format.raw/*87.107*/("""</span>
                <span class="muted"> committed """),_display_(/*88.49*/gitbucket/*88.58*/.core.helper.html.datetimeago(commit.commitTime)),format.raw/*88.106*/("""</span>
              </div>
            """)))} else {null} ),format.raw/*90.14*/("""
          """),format.raw/*91.11*/("""</div>
        </td>
      </tr>
    </table>
    """),_display_(/*95.6*/gitbucket/*95.15*/.core.helper.html.diff(diffs, repository, Some(commit.id), oldCommitId, true, None, hasWritePermission, true)),format.raw/*95.124*/("""
    """),format.raw/*96.5*/("""<label class="checkbox">
      <input type="checkbox" id="show-notes"> Show line notes below
    </label>
    <div id="comment-list">
      """),_display_(/*100.8*/gitbucket/*100.17*/.core.issues.html.commentlist(
        issue        = None,
        comments     = comments.filter(_.asInstanceOf[CommitComment].fileName.isEmpty),
        isManageable = hasWritePermission,
        repository   = repository,
        pullreq      = None,
        renderScript = false)),format.raw/*106.30*/("""
      """),format.raw/*107.7*/("""<div style="display: none;">
        """),_display_(/*108.10*/gitbucket/*108.19*/.core.issues.html.commentlist(
          issue        = None,
          comments     = comments.map(_.asInstanceOf[CommitComment]).filter(_.fileName.isDefined).groupBy(_.fileName).map { case (fileName, comments) =>
            CommitComments(
              fileName          = fileName.get,
              commentedUserName = comments.head.commentedUserName,
              registeredDate    = comments.head.registeredDate,
              comments          = comments,
              diff              = None
            )
          }.toList,
          isManageable = hasWritePermission,
          repository   = repository,
          pullreq      = None,
          commitId     = Some(commitId))),format.raw/*122.41*/("""
      """),format.raw/*123.7*/("""</div>
    </div>
    """),_display_(/*125.6*/gitbucket/*125.15*/.core.repo.html.commentform(commitId = commitId, hasWritePermission = hasWritePermission, repository = repository)),format.raw/*125.129*/("""
  """)))}),format.raw/*126.4*/("""
""")))}),format.raw/*127.2*/("""
"""),format.raw/*128.1*/("""<script>
$(function()"""),format.raw/*129.13*/("""{"""),format.raw/*129.14*/("""
  """),format.raw/*130.3*/("""$('a.branch:first, a.tag:first').css("""),format.raw/*130.40*/("""{"""),format.raw/*130.41*/("""
    """),format.raw/*131.5*/("""'font-weight': 'bold',
    'color': '#555555'
  """),format.raw/*133.3*/("""}"""),format.raw/*133.4*/(""");

  """),_display_(if(branches.size > 5)/*135.25*/{_display_(Seq[Any](format.raw/*135.26*/("""
    """),format.raw/*136.5*/("""// hide branches
    """),_display_(/*137.6*/for(i <- 1 to branches.size - 2) yield /*137.38*/{_display_(Seq[Any](format.raw/*137.39*/("""
      """),format.raw/*138.7*/("""$('#branch-"""),_display_(/*138.19*/i),format.raw/*138.20*/("""').hide();
    """)))}),format.raw/*139.6*/("""
    """),format.raw/*140.5*/("""// add omit link
    $('#branch-"""),_display_(/*141.17*/(branches.size - 1)),format.raw/*141.36*/("""').before(
      $('<a href="javascript:void(0);" class="omit">...</a>').click(function()"""),format.raw/*142.79*/("""{"""),format.raw/*142.80*/("""
        """),_display_(/*143.10*/for(i <- 1 to branches.size - 2) yield /*143.42*/{_display_(Seq[Any](format.raw/*143.43*/("""
          """),format.raw/*144.11*/("""$('#branch-"""),_display_(/*144.23*/i),format.raw/*144.24*/("""').show();
          this.remove();
        """)))}),format.raw/*146.10*/("""
      """),format.raw/*147.7*/("""}"""),format.raw/*147.8*/(""")
    );
  """)))} else {null} ),format.raw/*149.4*/("""

  """),_display_(if(tags.size > 5)/*151.21*/{_display_(Seq[Any](format.raw/*151.22*/("""
    """),format.raw/*152.5*/("""// hide tags
    """),_display_(/*153.6*/for(i <- 1 to tags.size - 2) yield /*153.34*/{_display_(Seq[Any](format.raw/*153.35*/("""
      """),format.raw/*154.7*/("""$('#tag-"""),_display_(/*154.16*/i),format.raw/*154.17*/("""').hide();
    """)))}),format.raw/*155.6*/("""
    """),format.raw/*156.5*/("""// add omit link
    $('#tag-"""),_display_(/*157.14*/(tags.size - 1)),format.raw/*157.29*/("""').before(
      $('<a href="javascript:void(0);" class="omit">...</a>').click(function()"""),format.raw/*158.79*/("""{"""),format.raw/*158.80*/("""
        """),_display_(/*159.10*/for(i <- 1 to tags.size - 2) yield /*159.38*/{_display_(Seq[Any](format.raw/*159.39*/("""
          """),format.raw/*160.11*/("""$('#tag-"""),_display_(/*160.20*/i),format.raw/*160.21*/("""').show();
          this.remove();
        """)))}),format.raw/*162.10*/("""
      """),format.raw/*163.7*/("""}"""),format.raw/*163.8*/(""")
    );
  """)))} else {null} ),format.raw/*165.4*/("""

  """),format.raw/*167.3*/("""$('#show-notes').change(function() """),format.raw/*167.38*/("""{"""),format.raw/*167.39*/("""
    """),format.raw/*168.5*/("""if (this.checked) """),format.raw/*168.23*/("""{"""),format.raw/*168.24*/("""
      """),format.raw/*169.7*/("""$('.inline-comment').show();
    """),format.raw/*170.5*/("""}"""),format.raw/*170.6*/(""" """),format.raw/*170.7*/("""else """),format.raw/*170.12*/("""{"""),format.raw/*170.13*/("""
      """),format.raw/*171.7*/("""$('.inline-comment').hide();
      $('.diff .inline-comment').show();
    """),format.raw/*173.5*/("""}"""),format.raw/*173.6*/("""
  """),format.raw/*174.3*/("""}"""),format.raw/*174.4*/(""");
"""),format.raw/*175.1*/("""}"""),format.raw/*175.2*/(""");
</script>
<style type="text/css">
a.branch, a.tag """),format.raw/*178.17*/("""{"""),format.raw/*178.18*/("""
  """),format.raw/*179.3*/("""color: #888888;
  margin-right: 4px;
"""),format.raw/*181.1*/("""}"""),format.raw/*181.2*/("""

"""),format.raw/*183.1*/("""a.omit """),format.raw/*183.8*/("""{"""),format.raw/*183.9*/("""
  """),format.raw/*184.3*/("""margin-right: 4px;
"""),format.raw/*185.1*/("""}"""),format.raw/*185.2*/("""
"""),format.raw/*186.1*/("""</style>
"""))
      }
    }
  }

  def render(commitId:String,commit:gitbucket.core.util.JGitUtil.CommitInfo,branches:List[String],tags:List[String],status:Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])],comments:List[gitbucket.core.model.Comment],repository:gitbucket.core.service.RepositoryService.RepositoryInfo,diffs:Seq[gitbucket.core.util.JGitUtil.DiffInfo],oldCommitId:Option[String],hasWritePermission:Boolean,info:Option[Any],error:Option[Any],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(commitId,commit,branches,tags,status,comments,repository,diffs,oldCommitId,hasWritePermission,info,error)(context)

  def f:((String,gitbucket.core.util.JGitUtil.CommitInfo,List[String],List[String],Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])],List[gitbucket.core.model.Comment],gitbucket.core.service.RepositoryService.RepositoryInfo,Seq[gitbucket.core.util.JGitUtil.DiffInfo],Option[String],Boolean,Option[Any],Option[Any]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (commitId,commit,branches,tags,status,comments,repository,diffs,oldCommitId,hasWritePermission,info,error) => (context) => apply(commitId,commit,branches,tags,status,comments,repository,diffs,oldCommitId,hasWritePermission,info,error)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/repo/commit.scala.html
                  HASH: 4f311f7b91be88de5ce51c6a42376059e8847bdc
                  MATRIX: 947->1|1577->559|1620->595|1675->643|1734->674|1752->683|1815->737|1854->738|1884->742|1902->751|1966->806|2005->807|2037->812|2223->971|2239->978|2276->994|2310->1001|2325->1007|2349->1010|2453->1087|2493->1089|2536->1104|2573->1114|2589->1121|2626->1137|2659->1143|2674->1149|2698->1152|2807->1217|2846->1228|2915->1270|2931->1277|2985->1310|3062->1360|3101->1361|3142->1374|3202->1407|3218->1414|3280->1455|3342->1473|3381->1484|3491->1567|3530->1568|3573->1583|3697->1680|3714->1688|3740->1705|3800->1727|3847->1746|3884->1756|3900->1763|3937->1779|3971->1786|3987->1793|4030->1815|4087->1844|4110->1845|4141->1848|4169->1854|4222->1876|4265->1891|4330->1912|4388->1943|4427->1944|4470->1959|4587->2049|4600->2053|4626->2070|4683->2089|4730->2108|4767->2118|4783->2125|4820->2141|4854->2148|4878->2151|4928->2174|4950->2175|4980->2178|5004->2181|5057->2203|5100->2218|5165->2239|5204->2250|5384->2403|5423->2404|5468->2421|5563->2472|5634->2516|5673->2517|5718->2534|5807->2596|5823->2603|5860->2619|5896->2628|5911->2634|5943->2645|6009->2683|6025->2689|6074->2716|6138->2736|6181->2751|6285->2828|6300->2834|6325->2837|6419->2904|6458->2905|6501->2920|6571->2963|6586->2969|6620->2982|6649->2983|6701->3008|6716->3014|6737->3026|6787->3038|6834->3057|6871->3067|6887->3074|6924->3090|6960->3099|6987->3105|7053->3143|7069->3149|7107->3165|7148->3187|7183->3201|7228->3218|7314->3260|7353->3271|7472->3363|7488->3370|7532->3393|7575->3408|7609->3415|7625->3422|7716->3492|7795->3544|7813->3553|7883->3601|7933->3624|7948->3630|7961->3634|8029->3664|8074->3682|8092->3691|8173->3751|8220->3767|8261->3780|8340->3832|8380->3834|8423->3849|8563->3962|8579->3969|8677->4045|8760->4101|8778->4110|8848->4158|8934->4200|8973->4211|9050->4262|9068->4271|9199->4380|9231->4385|9399->4526|9418->4535|9724->4819|9759->4826|9825->4864|9844->4873|10558->5565|10593->5572|10643->5595|10662->5604|10799->5718|10834->5722|10867->5724|10896->5725|10946->5746|10976->5747|11007->5750|11073->5787|11103->5788|11136->5793|11212->5841|11241->5842|11297->5870|11337->5871|11370->5876|11419->5898|11468->5930|11508->5931|11543->5938|11583->5950|11606->5951|11653->5967|11686->5972|11747->6005|11788->6024|11906->6113|11936->6114|11974->6124|12023->6156|12063->6157|12103->6168|12143->6180|12166->6181|12243->6226|12278->6233|12307->6234|12363->6246|12413->6268|12453->6269|12486->6274|12531->6292|12576->6320|12616->6321|12651->6328|12688->6337|12711->6338|12758->6354|12791->6359|12849->6389|12886->6404|13004->6493|13034->6494|13072->6504|13117->6532|13157->6533|13197->6544|13234->6553|13257->6554|13334->6599|13369->6606|13398->6607|13454->6619|13486->6623|13550->6658|13580->6659|13613->6664|13660->6682|13690->6683|13725->6690|13786->6723|13815->6724|13844->6725|13878->6730|13908->6731|13943->6738|14045->6812|14074->6813|14105->6816|14134->6817|14165->6820|14194->6821|14276->6874|14306->6875|14337->6878|14402->6915|14431->6916|14461->6918|14496->6925|14525->6926|14556->6929|14603->6948|14632->6949|14661->6950
                  LINES: 14->1|28->13|29->14|30->15|33->16|33->16|33->16|33->16|34->17|34->17|34->17|34->17|35->18|39->22|39->22|39->22|39->22|39->22|39->22|40->23|40->23|41->24|41->24|41->24|41->24|41->24|41->24|41->24|42->25|43->26|44->27|44->27|44->27|45->28|45->28|46->29|46->29|46->29|46->29|47->30|48->31|49->32|49->32|50->33|52->35|52->35|52->35|52->35|53->36|53->36|53->36|53->36|53->36|53->36|53->36|53->36|53->36|53->36|53->36|54->37|55->38|56->39|57->40|57->40|58->41|60->43|60->43|60->43|60->43|61->44|61->44|61->44|61->44|61->44|61->44|61->44|61->44|61->44|61->44|62->45|63->46|64->47|65->48|72->55|72->55|73->56|74->57|75->58|75->58|76->59|77->60|77->60|77->60|77->60|77->60|77->60|77->60|77->60|77->60|78->61|79->62|79->62|79->62|79->62|81->64|81->64|82->65|83->66|83->66|83->66|83->66|84->67|84->67|84->67|84->67|85->68|85->68|85->68|85->68|85->68|85->68|85->68|85->68|85->68|86->69|86->69|87->70|89->72|90->73|94->77|94->77|94->77|95->78|95->78|95->78|95->78|96->79|96->79|96->79|97->80|97->80|97->80|97->80|98->81|98->81|98->81|99->82|100->83|101->84|101->84|102->85|104->87|104->87|104->87|105->88|105->88|105->88|107->90|108->91|112->95|112->95|112->95|113->96|117->100|117->100|123->106|124->107|125->108|125->108|139->122|140->123|142->125|142->125|142->125|143->126|144->127|145->128|146->129|146->129|147->130|147->130|147->130|148->131|150->133|150->133|152->135|152->135|153->136|154->137|154->137|154->137|155->138|155->138|155->138|156->139|157->140|158->141|158->141|159->142|159->142|160->143|160->143|160->143|161->144|161->144|161->144|163->146|164->147|164->147|166->149|168->151|168->151|169->152|170->153|170->153|170->153|171->154|171->154|171->154|172->155|173->156|174->157|174->157|175->158|175->158|176->159|176->159|176->159|177->160|177->160|177->160|179->162|180->163|180->163|182->165|184->167|184->167|184->167|185->168|185->168|185->168|186->169|187->170|187->170|187->170|187->170|187->170|188->171|190->173|190->173|191->174|191->174|192->175|192->175|195->178|195->178|196->179|198->181|198->181|200->183|200->183|200->183|201->184|202->185|202->185|203->186
                  -- GENERATED --
              */
          