
package gitbucket.core.account.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object newrepo extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[List[String],Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(groupNames: List[String],
isCreateRepoOptionPublic: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*4.2*/gitbucket/*4.11*/.core.html.main("Create a New Repository")/*4.53*/{_display_(Seq[Any](format.raw/*4.54*/("""
"""),format.raw/*5.1*/("""<div class="content-wrapper main-center">
  <div class="content body">
    <h2>Create a new repository</h2>
    <p class="muted">
      A repository contains all your project's files, including revision history.
    </p>
    <form id="form" method="post" action=""""),_display_(/*11.44*/context/*11.51*/.path),format.raw/*11.56*/("""/new" validate="true" autocomplete="off">
      <fieldset class="border-top form-group">
        <dl style="float: left;">
          <dt>Owner</dt>
          <dd style="margin-left: 0px;">
            <div class="btn-group" id="owner-dropdown">
              <button class="btn dropdown-toggle btn-default" data-toggle="dropdown">
                <span class="strong">"""),_display_(/*18.39*/helpers/*18.46*/.avatar(context.loginAccount.get.userName, 20)),format.raw/*18.92*/(""" """),_display_(/*18.94*/context/*18.101*/.loginAccount.get.userName),format.raw/*18.127*/("""</span>
                <span class="caret"></span>
              </button>
              <ul class="dropdown-menu">
                <li><a href="javascript:void(0);" data-name=""""),_display_(/*22.63*/context/*22.70*/.loginAccount.get.userName),format.raw/*22.96*/(""""><i class="octicon octicon-check"></i> <span>"""),_display_(/*22.143*/helpers/*22.150*/.avatar(context.loginAccount.get.userName, 20)),format.raw/*22.196*/(""" """),_display_(/*22.198*/context/*22.205*/.loginAccount.get.userName),format.raw/*22.231*/("""</span></a></li>
                """),_display_(/*23.18*/groupNames/*23.28*/.map/*23.32*/ { groupName =>_display_(Seq[Any](format.raw/*23.47*/("""
                  """),format.raw/*24.19*/("""<li><a href="javascript:void(0);" data-name=""""),_display_(/*24.65*/groupName),format.raw/*24.74*/(""""><i class="octicon"></i> <span>"""),_display_(/*24.107*/helpers/*24.114*/.avatar(groupName, 20)),format.raw/*24.136*/(""" """),_display_(/*24.138*/groupName),format.raw/*24.147*/("""</span></a></li>
                """)))}),format.raw/*25.18*/("""
              """),format.raw/*26.15*/("""</ul>
              <input type="hidden" name="owner" id="owner" value=""""),_display_(/*27.68*/context/*27.75*/.loginAccount.get.userName),format.raw/*27.101*/(""""/>
            </div>
          </dd>
        </dl>
        <span class="slash" style="float: left; margin-left: 10px; margin-right: 10px; margin-top: 15px;">/</span>
        <dl>
          <dt>Repository name</dt>
          <dd style="margin-left: 0px;">
            <input type="text" name="name" id="name" class="form-control" style="width: 300px; display: inline;" autofocus aria-label="Repository name"/>
            <span id="error-name" class="error"></span>
          </dd>
        </dl>
      </fieldset>
      <fieldset class="form-group">
        <label for="description" class="strong">Description (optional):</label>
        <input type="text" name="description" id="description" class="form-control" />
      </fieldset>
      <fieldset class="border-top">
        <label class="radio">
          <input type="radio" name="isPrivate" value="false" """),_display_(if(isCreateRepoOptionPublic)/*46.91*/{_display_(Seq[Any](format.raw/*46.92*/("""checked""")))} else {null} ),format.raw/*46.100*/(""">
          <span class="strong"><i class="octicon octicon-repo"></i>&nbsp;</i>&nbsp;Public</span>
          <div class="normal muted">
            Anyone can see this repository. You choose who can commit.
          </div>
        </label>
        <label class="radio">
          <input type="radio" name="isPrivate" value="true" """),_display_(if(!isCreateRepoOptionPublic)/*53.91*/{_display_(Seq[Any](format.raw/*53.92*/("""checked""")))} else {null} ),format.raw/*53.100*/(""">
          <span class="strong"><i class="octicon octicon-lock"></i>&nbsp;</i>&nbsp;Private</span>
          <div class="normal muted">
            You choose who can see and commit to this repository.
          </div>
        </label>
      </fieldset>
      <fieldset class="border-top">
        <label class="radio">
          <input type="radio" name="initOption" value="EMPTY" checked/>
          <span class="strong">Create an empty repository</span>
          <div class="normal muted">
            Create an empty repository. You must initialize it yourself.
          </div>
        </label>
        <label class="radio">
          <input type="radio" name="initOption" value="EMPTY_COMMIT"/>
          <span class="strong">Initialize this repository with an empty commit</span>
          <div class="normal muted">
            Create an empty repository with an empty commit. You can clone the repository immediately.
          </div>
        </label>
        <label class="radio">
          <input type="radio" name="initOption" value="README"/>
          <span class="strong">Initialize this repository with a README</span>
          <div class="normal muted">
            Create a repository and commit README.md. You can clone the repository immediately.
          </div>
        </label>
        <label class="radio">
          <input type="radio" name="initOption" value="COPY"/>
          <span class="strong">Copy existing git repository</span>
          <div class="normal muted">
            Create a new repository by cloning an existing git repository.
          </div>
        </label>
        <input type="text" class="form-control" name="sourceUrl" id="sourceUrl" disabled placeholder="Source git repository URL..." aria-label="Source URL"/>
        <span id="error-sourceUrl" class="error"></span>
      </fieldset>
      <fieldset class="border-top form-actions">
        <input type="submit" class="btn btn-success" value="Create repository"/>
      </fieldset>
    </form>
  </div>
</div>
""")))}),format.raw/*98.2*/("""
"""),format.raw/*99.1*/("""<script>
$('#owner-dropdown a').click(function()"""),format.raw/*100.40*/("""{"""),format.raw/*100.41*/("""
  """),format.raw/*101.3*/("""var userName = $(this).data('name');
  $('#owner').val(userName);

  $('#owner-dropdown i').attr('class', 'octicon');
  $(this).find('i').attr('class', 'octicon octicon-check');

  $('#owner-dropdown span.strong').html($(this).find('span').html());
"""),format.raw/*108.1*/("""}"""),format.raw/*108.2*/(""");

$('input[name=initOption]').click(function () """),format.raw/*110.47*/("""{"""),format.raw/*110.48*/("""
  """),format.raw/*111.3*/("""$('#sourceUrl').prop('disabled', $('input[name=initOption]:checked').val() != 'COPY');
"""),format.raw/*112.1*/("""}"""),format.raw/*112.2*/(""");
</script>
"""))
      }
    }
  }

  def render(groupNames:List[String],isCreateRepoOptionPublic:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(groupNames,isCreateRepoOptionPublic)(context)

  def f:((List[String],Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (groupNames,isCreateRepoOptionPublic) => (context) => apply(groupNames,isCreateRepoOptionPublic)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/account/newrepo.scala.html
                  HASH: 263aedab6ccc846facaabcddc341414ca2f3c5cd
                  MATRIX: 633->1|820->117|883->153|900->162|950->204|988->205|1015->206|1306->470|1322->477|1348->482|1744->851|1760->858|1827->904|1856->906|1873->913|1921->939|2127->1118|2143->1125|2190->1151|2265->1198|2282->1205|2350->1251|2380->1253|2397->1260|2445->1286|2506->1320|2525->1330|2538->1334|2591->1349|2638->1368|2711->1414|2741->1423|2802->1456|2819->1463|2863->1485|2893->1487|2924->1496|2989->1530|3032->1545|3132->1618|3148->1625|3196->1651|4115->2543|4154->2544|4207->2552|4595->2913|4634->2914|4687->2922|6737->4942|6765->4943|6842->4991|6872->4992|6903->4995|7180->5244|7209->5245|7288->5295|7318->5296|7349->5299|7464->5386|7493->5387
                  LINES: 14->1|18->3|21->4|21->4|21->4|21->4|22->5|28->11|28->11|28->11|35->18|35->18|35->18|35->18|35->18|35->18|39->22|39->22|39->22|39->22|39->22|39->22|39->22|39->22|39->22|40->23|40->23|40->23|40->23|41->24|41->24|41->24|41->24|41->24|41->24|41->24|41->24|42->25|43->26|44->27|44->27|44->27|63->46|63->46|63->46|70->53|70->53|70->53|115->98|116->99|117->100|117->100|118->101|125->108|125->108|127->110|127->110|128->111|129->112|129->112
                  -- GENERATED --
              */
          