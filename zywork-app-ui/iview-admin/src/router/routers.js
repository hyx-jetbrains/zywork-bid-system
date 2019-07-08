import Main from '@/components/main'
import parentView from '@/components/parent-view'
import config from '../config'

const baseUrl = process.env.NODE_ENV === 'development' ? config.baseUrl.devServer : config.baseUrl.proServer

/**
 * iview-admin中meta除了原生参数外可配置的参数:
 * meta: {
 *  title: { String|Number|Function }
 *         显示在侧边栏、面包屑和标签栏的文字
 *         使用'{{ 多语言字段 }}'形式结合多语言使用，例子看多语言的路由配置;
 *         可以传入一个回调函数，参数是当前路由对象，例子看动态路由和带参路由
 *  hideInBread: (false) 设为true后此级路由将不会出现在面包屑中，示例看QQ群路由配置
 *  hideInMenu: (false) 设为true后在左侧菜单不会显示该页面选项
 *  notCache: (false) 设为true后页面在切换标签后不会缓存，如果需要缓存，无需设置这个字段，而且需要设置页面组件name属性和路由配置的name一致
 *  access: (null) 可访问该页面的权限数组，当前路由设置的权限会影响子路由
 *  icon: (-) 该页面在左侧菜单、面包屑和标签导航处显示的图标，如果是自定义图标，需要在图标名称前加下划线'_'
 *  beforeCloseName: (-) 设置该字段，则在关闭当前tab页时会去'@/router/before-close.js'里寻找该字段名对应的方法，作为关闭前的钩子函数
 * }
 */

export default [
  {
    path: '/login',
    name: 'login',
    meta: {
      title: 'zywok-app - 登录',
      hideInMenu: true
    },
    component: () => import('@/view/login/login.vue')
  },
  {
    path: '/',
    name: '_home',
    redirect: '/home',
    component: Main,
    meta: {
      hideInMenu: true,
      notCache: true
    },
    children: [
      {
        path: '/home',
        name: 'home',
        meta: {
          hideInMenu: true,
          title: '首页',
          notCache: true,
          icon: 'md-home'
        },
        component: () => import('@/view/single-page/home')
      },
      {
        path: 'UserInfo',
        name: 'user_info',
        meta: {
          title: '个人信息',
          icon: 'ios-contact',
          hideInMenu: true,
          notCache: true
        },
        component: () => import('@/view/user-info/UserInfo.vue')
      },
      {
        path: 'ActivitiTasks',
        name: 'activiti_tasks',
        meta: {
          title: '我的流程任务',
          icon: 'ios-contact',
          hideInMenu: true,
          notCache: true,
          notCache: true
        },
        component: () => import('@/view/activiti-tasks/ActivitiTasks.vue')
      },
    ]
  },
  {
    path: '/admin',
    name: 'bid_info',
    meta: {
      icon: 'md-home',
      title: '招标信息'
    },
    component: Main,
    children: [
      {
        path: 'Advertisement',
        name: 'advertisement_manage',
        meta: {
          title: '轮播广告管理',
          icon: 'ios-locate'
        },
        component: () => import('@/view/advertisement/Advertisement.vue')
      },
      {
        path: 'Headlines',
        name: 'headlines_manage',
        meta: {
          title: '头条管理',
          icon: 'ios-headset'
        },
        component: () => import('@/view/headlines/Headlines.vue')
      },
      {
        path: 'Project',
        name: 'project_manage',
        meta: {
          title: '招投标项目管理',
          icon: 'ios-bookmark'
        },
        component: () => import('@/view/project/Project.vue')
      },
      {
        path: 'ProjectAnnounce',
        name: 'project_announce_manage',
        meta: {
          title: '公示详情管理',
          icon: 'ios-barcode'
        },
        component: () => import('@/view/project-announce/ProjectAnnounce.vue')
      },
      {
        path: 'ProjectResource',
        name: 'project_resource_manage',
        meta: {
          title: '项目附件管理',
          icon: 'ios-link'
        },
        component: () => import('@/view/project-resource/ProjectResource.vue')
      },
    ]
  },
  {
    path: '/admin',
    name: 'info_share',
    meta: {
      icon: 'md-share',
      title: '信息共享'
    },
    component: Main,
    children: [
      {
        path: 'Builder',
        name: 'builder_manage',
        meta: {
          title: '发布建造师管理',
          icon: 'ios-contacts'
        },
        component: () => import('@/view/builder/Builder.vue')
      },
      {
        path: 'BuilderRequest',
        name: 'builder_req_manage',
        meta: {
          title: '发布建造师需求管理',
          icon: 'ios-contacts-outline'
        },
        component: () => import('@/view/builder-req/BuilderReq.vue')
      },
      {
        path: 'BuilderResource',
        name: 'builder_resource_manage',
        meta: {
          title: '建造师附件管理',
          icon: 'ios-link'
        },
        component: () => import('@/view/builder-resource/BuilderResource.vue')
      },
      {
        path: 'AptitudeTransfer',
        name: 'aptitude_transfer_manage',
        meta: {
          title: '发布资质转让管理',
          icon: 'ios-medal'
        },
        component: () => import('@/view/aptitude-transfer/AptitudeTransfer.vue')
      },
      {
        path: 'AptitudeResource',
        name: 'aptitude_resource_manage',
        meta: {
          title: '资质转让附件管理',
          icon: 'ios-link'
        },
        component: () => import('@/view/aptitude-resource/AptitudeResource.vue')
      },
      {
        path: 'MarkCarpool',
        name: 'mark_carpool_manage',
        meta: {
          title: '开标拼车管理',
          icon: 'ios-car'
        },
        component: () => import('@/view/mark-carpool/MarkCarpool.vue')
      },
      {
        path: 'MarkSeekcar',
        name: 'mark_seekcar_manage',
        meta: {
          title: '开标找车管理',
          icon: 'ios-car-outline'
        },
        component: () => import('@/view/mark-seekcar/MarkSeekcar.vue')
      },
      {
        path: 'RecruitInfo',
        name: 'recruit_info_manage',
        meta: {
          title: '招聘信息管理',
          icon: 'ios-medical'
        },
        component: () => import('@/view/recruit/Recruit.vue')
      },
      {
        path: 'SeekData',
        name: 'seek_data_manage',
        meta: {
          title: '求带资料管理',
          icon: 'ios-paper'
        },
        component: () => import('@/view/seek-data/SeekData.vue')
      },
      {
        path: 'Guarantee',
        name: 'guarantee_manage',
        meta: {
          title: '申请保函管理',
          icon: 'ios-paper-outline'
        },
        component: () => import('@/view/guarantee/Guarantee.vue')
      },
      {
        path: 'ExpertSubscribe',
        name: 'expert_subscribe_manage',
        meta: {
          title: '专家预约管理',
          icon: 'ios-person'
        },
        component: () => import('@/view/expert-subscribe/ExpertSubscribeList.vue')
      },
			{
			  path: 'UserExpert',
			  name: 'user_expert',
			  meta: {
			    title: '专家信息',
			    icon: 'ios-person'
			  },
			  component: () => import('@/view/user-expert/UserExpert.vue')
      },
      {
        path: 'UserExpertQuestionType',
        name: 'user_expert_question_type_manage',
        meta: {
          title: '专家类型管理',
          icon: 'ios-person'
        },
        component: () => import('@/view/user-expert-question-type/UserExpertQuestionType.vue')
      },
      {
        path: 'ExpertQuestionType',
        name: 'expert_question_type_manage',
        meta: {
          title: '专家问题类型管理',
          icon: 'ios-person'
        },
        component: () => import('@/view/expert-question-type/ExpertQuestionType.vue')
      },
			{
			  path: 'UpdateNotice',
			  name: 'update_notice',
			  meta: {
			    title: '通知公告',
			    icon: 'ios-person'
			  },
			  component: () => import('@/view/update-notice/UpdateNotice.vue')
      },
      {
        path: 'Labour',
        name: 'labour_manage',
        meta: {
          title: '劳务求职管理',
          icon: 'ios-people'
        },
        component: () => import('@/view/labour/Labour.vue')
      },
      {
        path: 'LabourRequest',
        name: 'labour_req_manage',
        meta: {
          title: '劳务招聘管理',
          icon: 'ios-people-outline'
        },
        component: () => import('@/view/labour-req/LabourReq.vue')
      },
      // {
      //   path: 'UpdateNoticeResource',
      //   name: 'update_notice_resource',
      //   meta: {
      //     title: '通知公告附件',
      //     icon: 'ios-person'
      //   },
      //   component: () => import('@/view/update-notice-resource/UpdateNoticeResource.vue')
      // },
    ]
  },
  {
    path: '/admin',
    name: 'credit_enquiry',
    meta: {
      icon: 'md-paper-plane',
      title: '征信查询'
    },
    component: Main,
    children: [
      {
        path: 'CompanyInfo',
        name: 'company_info_manage',
        meta: {
          title: '企业信息管理',
          icon: 'ios-people'
        },
        component: () => import('@/view/company/Company.vue')
      },
      {
        path: 'CompanyPersonnel',
        name: 'company_personnel_manage',
        meta: {
          title: '企业人员管理',
          icon: 'ios-people-outline'
        },
        component: () => import('@/view/comp-personnel/CompPersonnel.vue')
      },
      {
        path: 'CompanyBuilder',
        name: 'company_builder_manage',
        meta: {
          title: '企业建造师管理',
          icon: 'ios-contacts'
        },
        component: () => import('@/view/comp-builder/CompBuilder.vue')
      },
      {
        path: 'CompanyAptitude',
        name: 'company_aptitude_manage',
        meta: {
          title: '企业资质管理',
          icon: 'ios-medal'
        },
        component: () => import('@/view/comp-aptitude/CompAptitude.vue')
      },
      {
        path: 'CompanyHouseAchievement',
        name: 'company_house_achievement_manage',
        meta: {
          title: '企业房建业绩管理',
          icon: 'ios-paper-outline'
        },
        component: () => import('@/view/comp-house-achievement/CompHouseAchievement.vue')
      },
      {
        path: 'CompanyKeyProjectAchievement',
        name: 'company_key_project_achievement_manage',
        meta: {
          title: '企业重点工程业绩管理',
          icon: 'ios-paper-outline'
        },
        component: () => import('@/view/comp-key-project-achievement/CompKeyProjectAchievement.vue')
      },
      {
        path: 'CompanyTrafficAchievement',
        name: 'company_traffic_achievement_manage',
        meta: {
          title: '企业交通业绩管理',
          icon: 'ios-paper-outline'
        },
        component: () => import('@/view/comp-traffic-achievement/CompTrafficAchievement.vue')
      },
      {
        path: 'CompanyWaterAchievement',
        name: 'company_water_achievement_manage',
        meta: {
          title: '企业水利业绩管理',
          icon: 'ios-paper-outline'
        },
        component: () => import('@/view/comp-water-achievement/CompWaterAchievement.vue')
      },
      {
        path: 'CompanyWaterDeviseAchievement',
        name: 'company_water_devise_achievement_manage',
        meta: {
          title: '企业水利勘查业绩管理',
          icon: 'ios-paper-outline'
        },
        component: () => import('@/view/comp-water-devise-achievement/CompWaterDeviseAchievement.vue')
      },
      {
        path: 'CompanyWaterMonitorAchievement',
        name: 'company_water_monitor_achievement_manage',
        meta: {
          title: '企业水利监理业绩管理',
          icon: 'ios-paper-outline'
        },
        component: () => import('@/view/comp-water-monitor-achievement/CompWaterMonitorAchievement.vue')
      },
    ]
  },
  {
    path: '/admin',
    name: 'user_manage',
    meta: {
      icon: 'md-person',
      title: '用户管理'
    },
    component: Main,
    children: [
      {
        path: 'User',
        name: 'user_basic',
        meta: {
          title: '用户基础信息管理',
          icon: 'ios-person'
        },
        component: () => import('@/view/user/User.vue')
      },
			{
			  path: 'UserDetail',
			  name: 'user_detail_query',
			  meta: {
			    title: '用户详情管理',
			    icon: 'md-information-circle'
			  },
			  component: () => import('@/view/user-detail/UserUserDetail.vue')
      },
      {
        path: 'UserWorkInfo',
        name: 'user_work_info_query',
        meta: {
          title: '用户工作信息管理',
          icon: 'md-information-circle'
        },
        component: () => import('@/view/user-work/UserWork.vue')
      },
			{
			  path: 'UserSocial',
			  name: 'user_social_query',
			  meta: {
			    title: '用户第三方登录管理',
			    icon: 'md-share'
			  },
			  component: () => import('@/view/user-social/UserUserSocial.vue')
			},
			{
			  path: 'UserRole',
			  name: 'user_role_query',
			  meta: {
			    title: '用户角色查询',
			    icon: 'ios-lock'
			  },
			  component: () => import('@/view/user-role/UserRole.vue')
      },
      // 根据客户需求，不需要这个功能
      // {
      //   path: 'achievement',
      //   name: 'achievement_manage',
      //   meta: {
      //     title: '用户业绩查询',
      //     icon: 'ios-paper-outline'
      //   },
      //   component: () => import('@/view/achievement/Achievement.vue')
      // },
      {
        path: 'UserSubscribe',
        name: 'user_subscribe_manage',
        meta: {
          title: '用户订阅管理',
          icon: 'ios-paper-plane-outline'
        },
        component: () => import('@/view/subscribe/SubscribeList.vue')
      },
      {
        path: 'UserProjectCollection',
        name: 'user_project_collection_manage',
        meta: {
          title: '用户项目收藏管理',
          icon: 'ios-star'
        },
        component: () => import('@/view/project-collection/ProjectCollection.vue')
      },
      {
        path: 'UserResume',
        name: 'user_resume_manage',
        meta: {
          title: '用户简历管理',
          icon: 'ios-list'
        },
        component: () => import('@/view/resume/Resume.vue')
      },
      {
        path: 'UserConsult',
        name: 'user_consult_manage',
        meta: {
          title: '用户咨询管理',
          icon: 'ios-medkit'
        },
        component: () => import('@/view/consult/Consult.vue')
      },
      {
        path: 'Coupon',
        name: 'coupon_manage',
        meta: {
          title: '抵扣券管理',
          icon: 'md-pricetag'
        },
        component: () => import('@/view/coupon/Coupon.vue')
      },
      {
        path: 'UserCoupon',
        name: 'user_coupon_manage',
        meta: {
          title: '用户抵扣券管理',
          icon: 'ios-pricetag-outline'
        },
        component: () => import('@/view/user-coupon/UserCoupon.vue')
      },
      {
        path: 'CouponRecord',
        name: 'coupon_record',
        meta: {
          title: '抵扣券使用记录',
          icon: 'ios-paper-outline'
        },
        component: () => import('@/view/coupon-record/CouponRecord.vue')
      },
			{
			  path: 'UserService',
			  name: 'user_service',
			  meta: {
			    title: '用户服务',
			    icon: 'ios-paper-outline'
			  },
			  component: () => import('@/view/user-service/UserService.vue')
			},
    ]
  },
  {
    path: '/admin',
    name: 'user_fund_manage',
    meta: {
      icon: 'logo-yen',
      title: '用户资金管理'
    },
    component: Main,
    children: [
      {
        path: 'UserWallet',
        name: 'wallet_manage',
        meta: {
          title: '钱包管理',
          icon: 'md-cash'
        },
        component: () => import('@/view/user-wallet/UserWallet.vue')
      },
      {
        path: 'AccountDetail',
        name: 'user_account_manage',
        meta: {
          title: '账目管理',
          icon: 'md-list-box'
        },
        component: () => import('@/view/account-detail/AccountDetail.vue')
      }
    ]
  },
  {
    path: '/admin',
    name: 'report_statistics_management',
    meta: {
      icon: 'ios-podium',
      title: '报表统计管理'
    },
    component: Main,
    children: [
      {
        path: 'StatisticsDau',
        name: 'statistics_dau',
        meta: {
          title: 'DAU统计管理',
          icon: 'ios-walk'
        },
        component: () => import('@/view/statistics-dau/StatisticsDau.vue')
      },
      {
        path: 'DauReport',
        name: 'dau_report',
        meta: {
          title: 'DAU统计报表',
          icon: 'ios-stats'
        },
        component: () => import('@/view/statistics-dau/dau-report.vue')
      }
    ]
  },
  {
    path: '/admin',
    name: 'system_premissoin_manage',
    meta: {
      icon: 'ios-lock',
      title: '系统权限管理'
    },
    component: Main,
    children: [
      {
        path: 'Role',
        name: 'role_manage',
        meta: {
          title: '角色管理',
          icon: 'md-lock'
        },
        component: () => import('@/view/role/Role.vue')
      },
      {
        path: 'Module',
        name: 'module_manage',
        meta: {
          title: '模块管理',
          icon: 'ios-list-box'
        },
        component: () => import('@/view/module/Module.vue')
      },
      {
        path: 'Permission',
        name: 'permission_manage',
        meta: {
          title: '权限管理',
          icon: 'ios-key'
        },
        component: () => import('@/view/permission/Permission.vue')
      },
			{
			  path: 'ModulePermission',
			  name: 'module_permission_query',
			  meta: {
			    title: '模块权限查询',
			    icon: 'md-options'
			  },
			  component: () => import('@/view/module-permission/ModulePermission.vue')
			},
			{
				path: 'role-permission-page',
				name: 'role_permission_query',
				meta: {
					title: '角色权限查询',
					icon: 'md-key'
				},
				component: () => import('@/view/role-permission/RolePermissions.vue')
			}
    ]
  },
  {
    path: '/admin',
    name: 'sys_content_manage',
    meta: {
      icon: 'md-book',
      title: '系统内容管理'
    },
    component: Main,
    children: [
      {
        path: 'SysConfig',
        name: 'system_config',
        meta: {
          title: '系统配置管理',
          icon: 'ios-cog'
        },
        component: () => import('@/view/sys-config/SysConfig.vue')
      },
      {
        path: 'SysInfo',
        name: 'system_info',
        meta: {
          title: '系统信息管理',
          icon: 'ios-cog'
        },
        component: () => import('@/view/sys-info/SysInfo.vue')
      },
      // {
      //   path: 'Message',
      //   name: 'system_message',
      //   meta: {
      //     title: '消息管理',
      //     icon: 'ios-information-circle'
      //   },
      //   component: () => import('@/view/message/Message.vue')
      // },
      {
        path: 'UserMessage',
        name: 'user_message',
        meta: {
          title: '用户消息查询',
          icon: 'ios-information-circle'
        },
        component: () => import('@/view/user-message/UserUserMessage.vue')
      },
      {
        path: 'OftenQuestion',
        name: 'often_question_manage',
        meta: {
          title: '常见问题管理',
          icon: 'ios-git-network'
        },
        component: () => import('@/view/often-question/OftenQuestion.vue')
      },
      {
        path: 'Resource',
        name: 'resource_manage',
        meta: {
          title: '资源附件管理',
          icon: 'ios-link'
        },
        component: () => import('@/view/resource/ResourceList.vue')
      },
			{
			  path: 'Service',
			  name: 'service',
			  meta: {
			    title: '服务配置',
			    icon: 'ios-link'
			  },
			  component: () => import('@/view/service/Service.vue')
			}
    ]
  },
  {
    path: '/admin',
    name: 'system_monitoring',
    meta: {
      icon: 'md-eye',
      title: '缓存管理'
    },
    component: Main,
    children: [
			{
			  path: 'SysLog',
			  name: 'system_log',
			  meta: {
			    title: '系统日志管理',
			    icon: 'ios-paper'
			  },
			  component: () => import('@/view/sys-log/SysLog.vue')
			},
			{
			  path: 'Scheduler',
			  name: 'timing_task',
			  meta: {
			    title: '定时任务管理',
			    icon: 'md-time'
			  },
			  component: () => import('@/view/scheduler/Scheduler.vue')
			},
      {
        path: 'RedisCache',
        name: 'redis_cache',
        meta: {
          title: 'Redis缓存管理',
          icon: 'ios-ionitron'
        },
        component: () => import('@/view/redis-cache/RedisCache.vue')
      },
      // {
      //   path: 'DruidSql',
      //   name: 'druid_sql',
      //   meta: {
      //     title: 'Druid SQL监控',
      //     href: baseUrl + ':8088/druid/index.html',
      //     icon: 'md-trending-up'
      //   }
      // },
      // {
      //   path: 'SpringBootAdmin',
      //   name: 'spring_boot_admin',
      //   meta: {
      //     title: 'SpringBoot Admin',
      //     href: baseUrl + ':8086',
      //     icon: 'md-speedometer'
      //   }
      // }
    ]
  },
  {
    path: '/401',
    name: 'error_401',
    meta: {
      hideInMenu: true
    },
    component: () => import('@/view/error-page/401.vue')
  },
  {
    path: '/500',
    name: 'error_500',
    meta: {
      hideInMenu: true
    },
    component: () => import('@/view/error-page/500.vue')
  },
  {
    path: '*',
    name: 'error_404',
    meta: {
      hideInMenu: true
    },
    component: () => import('@/view/error-page/404.vue')
  }
]
